package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Boolean existsByAddress(String address);
    String deleteByAddress(String address);
    Warehouse findByAddress(String address);
}
