package com.moin.UserService.service.impl;


import com.moin.UserService.entity.BookEntity;
import com.moin.UserService.entity.ReviewEntity;
import com.moin.UserService.entity.UserEntity;
import com.moin.UserService.exceptions.ResourceNotFoundException;
import com.moin.UserService.repository.UserRepositories;
import com.moin.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        String id = UUID.randomUUID().toString();
        userEntity.setUserId(id);
        return userRepositories.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepositories.findAll();
    }

    @Override
    public UserEntity getUserByUserId(String userId) {
        UserEntity user = userRepositories.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ReviewEntity[] reviewList= restTemplate.getForObject("http://localhost:8083/review/allByUserId/"+userId, ReviewEntity[].class);

        List<ReviewEntity> ratings= Arrays.stream(reviewList).toList();

        List<ReviewEntity> ratingList = ratings.stream().map(review -> {
            BookEntity bookEntity= restTemplate.getForObject("http://BOOK-SERVICE/review/allByBookId/"+review.getBookId(), BookEntity.class);
            review.setBookEntity(bookEntity);
            return review;
        }).collect(Collectors.toList());


        user.setReview(ratingList);
        return user;
    }
}

