package com.moin.ReviewService.controller;

import com.moin.ReviewService.entity.ReviewEntity;
import com.moin.ReviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/create")
    public ResponseEntity<ReviewEntity> createReview(@RequestBody ReviewEntity reviewEntity) {
        ReviewEntity review = reviewService.createReview(reviewEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ReviewEntity>>  getAllReview(){
        List<ReviewEntity> allReview = reviewService.getAllReview();
        return ResponseEntity.ok(allReview);
    }

    @GetMapping("/allByUserId/{userId}")
    public ResponseEntity<List<ReviewEntity>>  getReviewByUserId(@PathVariable String userId){
        List<ReviewEntity> allReviewByUserId = reviewService.getReviewByUserId(userId);
        return ResponseEntity.ok(allReviewByUserId);
    }

    @GetMapping("/allByBookId/{bookId}")
    public ResponseEntity<List<ReviewEntity>>  getReviewByBookId(@PathVariable String bookId){
        List<ReviewEntity> allReviewByBookId = reviewService.getReviewByBookId(bookId);
        return ResponseEntity.ok(allReviewByBookId);
    }
}
