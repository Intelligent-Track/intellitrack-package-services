package com.architechz.project.packageservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Boolean existsByAddress(String address);
    String deleteByAddress(String address);
    Warehouse findByAddress(String address);
    public List<Warehouse> findByCityId(Long idCity);
    public List<Warehouse> findByTypeId(Long idType);

}
