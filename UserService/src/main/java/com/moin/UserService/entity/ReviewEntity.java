package com.moin.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
    private String reviewId;
    private String userId;
    private String BookId;
    private String review;
    private BookEntity bookEntity;
}
