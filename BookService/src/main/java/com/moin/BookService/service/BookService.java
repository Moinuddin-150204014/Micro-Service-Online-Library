package com.moin.BookService.service;

import com.moin.BookService.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity create(BookEntity book);

    List<BookEntity> getAllBooks();

    BookEntity getBook(String id);
}
