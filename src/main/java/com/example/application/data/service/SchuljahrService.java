package com.example.application.data.service;

import com.example.application.data.entity.Schuljahr;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SchuljahrService {

    private final SchuljahrRepository repository;

    public SchuljahrService(SchuljahrRepository repository) {
        this.repository = repository;
    }

    public Optional<Schuljahr> get(Long id) {
        return repository.findById(id);
    }

    public Schuljahr update(Schuljahr entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Schuljahr> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Schuljahr> list(Pageable pageable, Specification<Schuljahr> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }
}
