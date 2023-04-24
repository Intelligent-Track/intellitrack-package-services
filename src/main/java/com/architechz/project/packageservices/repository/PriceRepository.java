package com.architechz.project.packageservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    public List<Price> findByTruckType(int truckType);
}
