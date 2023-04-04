package com.example.application.data.service;

import com.example.application.data.entity.testing_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface testing_UserRepository extends JpaRepository<testing_User, Long>, JpaSpecificationExecutor<testing_User> {

    testing_User findByUsername(String username);
}
