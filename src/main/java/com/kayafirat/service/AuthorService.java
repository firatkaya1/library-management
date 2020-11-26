package com.kayafirat.service;

import com.kayafirat.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author addAuthor(Author author);

    void deleteAuthor(long id);

    Author updateAuthor(Author author);

    Optional<Author> getAuthor(long authorId);

    List<Author> getAllAuthor();
}
