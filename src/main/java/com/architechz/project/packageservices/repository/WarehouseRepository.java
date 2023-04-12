package com.architechz.project.packageservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    public List<Warehouse> findByCityId(Long idCity);
    public List<Warehouse> findByTypeId(Long idType);

}
