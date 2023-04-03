package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    
}
