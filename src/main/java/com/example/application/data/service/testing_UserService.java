package com.example.application.data.service;

import com.example.application.data.entity.testing_User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class testing_UserService {

    private final testing_UserRepository repository;

    public testing_UserService(testing_UserRepository repository) {
        this.repository = repository;
    }

    public Optional<testing_User> get(Long id) {
        return repository.findById(id);
    }

    public testing_User update(testing_User entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<testing_User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<testing_User> list(Pageable pageable, Specification<testing_User> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
