package com.kayafirat.service.Impl;

import com.kayafirat.entity.Book;
import com.kayafirat.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookService implements com.kayafirat.service.IBookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> searchBook(String keyword, int pageNumber, int pageSize, String sortedBy, String orderBy) {
        Sort sort;
        if (orderBy.equals("asc"))
            sort = Sort.by(sortedBy).ascending();
        else
            sort = Sort.by(sortedBy).descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return bookRepository.findAll(pageable);
    }
}
