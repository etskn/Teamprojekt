package com.example.application.data.service;

import com.example.application.data.entity.Szenario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SzenarioService {

    private final SzenarioRepository repository;

    public SzenarioService(SzenarioRepository repository) {
        this.repository = repository;
    }

    public Optional<Szenario> get(Long id) {
        return repository.findById(id);
    }

    public Szenario update(Szenario entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Szenario> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Szenario> list(Pageable pageable, Specification<Szenario> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}