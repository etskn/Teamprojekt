package com.example.application.data.service;

import com.example.application.data.entity.Szenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SzenarioRepository extends JpaRepository<Szenario, Long>, JpaSpecificationExecutor<Szenario> {



}
