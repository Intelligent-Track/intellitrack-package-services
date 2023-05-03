package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Package;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    Boolean existsByType(String type);

    public List<Package> findAllByDeliveryId(Long id);

    public List<Package> findAllByIdClient(int id);
}
