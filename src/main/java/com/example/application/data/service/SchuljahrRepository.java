package com.example.application.data.service;

import com.example.application.data.entity.Schuljahr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchuljahrRepository extends JpaRepository<Schuljahr, Long>, JpaSpecificationExecutor<Schuljahr> {
}