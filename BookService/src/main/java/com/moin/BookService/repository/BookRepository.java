package com.moin.BookService.repository;

import com.moin.BookService.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {

}
