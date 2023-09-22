package com.moin.BookService.controller;

import com.moin.BookService.entity.BookEntity;
import com.moin.BookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity) {
        BookEntity book = bookService.create(bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id){

        try {
            BookEntity book = bookService.getBook(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookEntity>>  getAllBook(){
        List<BookEntity> allBook = bookService.getAllBooks();
        return ResponseEntity.ok(allBook);
    }

}

