package com.moin.ReviewService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("review")
public class ReviewEntity {
    @Id
    private String reviewId;
    private String userId;
    private String bookId;
    private String review;
}
