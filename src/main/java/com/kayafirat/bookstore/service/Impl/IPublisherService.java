package com.kayafirat.bookstore.service.Impl;

import com.kayafirat.bookstore.entity.Publisher;
import com.kayafirat.bookstore.repository.PublisherRepository;
import com.kayafirat.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPublisherService implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Optional<Publisher> getPublisher(long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }
}
