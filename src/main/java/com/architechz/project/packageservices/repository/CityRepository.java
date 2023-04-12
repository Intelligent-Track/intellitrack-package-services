package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    
}
