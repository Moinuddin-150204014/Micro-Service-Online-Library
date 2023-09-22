package com.moin.ReviewService.service.impl;

import com.moin.ReviewService.entity.ReviewEntity;
import com.moin.ReviewService.repository.ReviewRepository;
import com.moin.ReviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public ReviewEntity createReview(ReviewEntity reviewEntity) {
        return reviewRepository.save(reviewEntity);
    }

    @Override
    public List<ReviewEntity> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public List<ReviewEntity> getReviewByUserId(String userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<ReviewEntity> getReviewByBookId(String bookId) {
        return reviewRepository.findByBookId(bookId);
    }
}
