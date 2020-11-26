package com.kayafirat.service.Impl;

import com.kayafirat.entity.Publisher;
import com.kayafirat.repository.PublisherRepository;
import com.kayafirat.service.IPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublisherService implements IPublisherService {

    private final PublisherRepository publisherRepository;

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
