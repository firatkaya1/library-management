package com.kayafirat.service.Impl;

import com.kayafirat.entity.Author;
import com.kayafirat.repository.AuthorRepository;
import com.kayafirat.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

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
