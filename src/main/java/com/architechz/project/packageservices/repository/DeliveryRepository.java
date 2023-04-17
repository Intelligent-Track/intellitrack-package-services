package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    
}
