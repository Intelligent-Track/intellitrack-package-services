package com.architechz.project.packageservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.packageservices.models.Package;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    public List<Package> findAllByDeliveryId(Long id);
}
