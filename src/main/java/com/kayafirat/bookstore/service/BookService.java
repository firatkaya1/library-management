package com.kayafirat.bookstore.service;

import com.kayafirat.bookstore.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book addBook(Book book);

    void deleteBook(long id);

    Book updateBook(Book book);

    Optional<Book> getBook(long id);

    List<Book> getAllBook();

    Page<Book> searchBook(String keyword, int pageNumber, int pageSize, String sortedBy, String orderBy);


}
