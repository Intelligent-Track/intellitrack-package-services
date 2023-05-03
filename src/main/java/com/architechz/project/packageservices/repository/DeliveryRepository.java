package com.architechz.project.packageservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.enums.Status;
import com.architechz.project.packageservices.models.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    public List<Delivery> findAllDeliveriesByIdDriver(Long idDriver);
    public List<Delivery> findAllDeliveriesByIdDriverAndStatus(Long idDriver, Status status);
    public List<Delivery> findAllDeliveriesByStatus(Status status);
    public List<Delivery> findAllDeliveriesByNit(String nit);
    
}
