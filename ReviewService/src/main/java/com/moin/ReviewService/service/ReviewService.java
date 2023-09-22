package com.moin.ReviewService.service;

import com.moin.ReviewService.entity.ReviewEntity;

import java.util.List;

public interface ReviewService {
    ReviewEntity createReview(ReviewEntity reviewEntity) ;
    List<ReviewEntity> getAllReview();
    List<ReviewEntity> getReviewByUserId(String userId) ;
    List<ReviewEntity> getReviewByBookId(String bookId) ;

}
