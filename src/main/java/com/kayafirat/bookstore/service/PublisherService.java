package com.kayafirat.bookstore.service;

import com.kayafirat.bookstore.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    Publisher addPublisher(Publisher publisher);

    void deletePublisher(long id);

    Publisher updatePublisher(Publisher publisher);

    Optional<Publisher> getPublisher(long id);

    List<Publisher> getAllPublisher();
}
