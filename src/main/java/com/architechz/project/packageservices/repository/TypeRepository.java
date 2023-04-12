package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architechz.project.packageservices.models.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
    
}
