package com.kayafirat.bookstore.service.Impl;

import com.kayafirat.bookstore.entity.Author;
import com.kayafirat.bookstore.repository.AuthorRepository;
import com.kayafirat.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IAuthorService implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> getAuthor(long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
