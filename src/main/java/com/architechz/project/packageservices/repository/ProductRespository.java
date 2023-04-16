package com.architechz.project.packageservices.repository;

import com.architechz.project.packageservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRespository extends JpaRepository<Product, Long> {

    public List<Product> findAllByDeliveryId(Long id);

    @Query(value = "SELECT max(id) FROM products", nativeQuery = true)
    Long getLastId();
}
