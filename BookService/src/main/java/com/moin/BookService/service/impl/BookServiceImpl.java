package com.moin.BookService.service.impl;

import com.moin.BookService.entity.BookEntity;
import com.moin.BookService.exception.BookNotFoundException;
import com.moin.BookService.repository.BookRepository;
import com.moin.BookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired

    private BookRepository bookRepository;

    @Override
    public BookEntity create(BookEntity bookEntity) {
        String bookId = UUID.randomUUID().toString();
        bookEntity.setBookId(bookId);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBook(String id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Book with the given id is not found on the server : " + id));
    }
}
