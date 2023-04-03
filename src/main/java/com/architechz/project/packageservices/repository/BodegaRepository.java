package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {
    
}
