package com.moin.BookService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookEntity {
    @Id
    private String bookId;
    private String title;
    private String authorName;
    private String genre;
}
