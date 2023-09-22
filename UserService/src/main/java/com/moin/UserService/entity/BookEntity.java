package com.moin.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    private String bookId;
    private String title;
    private String authorName;
    private String genre;
}
