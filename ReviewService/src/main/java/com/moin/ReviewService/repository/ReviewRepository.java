package com.moin.ReviewService.repository;

import com.moin.ReviewService.entity.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<ReviewEntity,String> {
    List<ReviewEntity> findByUserId(String userId);
    List<ReviewEntity> findByBookId(String bookId);
}
