package com.architechz.project.packageservices.repository;
import com.architechz.project.packageservices.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByPlate(int plate);
    void deleteByPlate(int plate);
    
}
