package com.architechz.project.packageservices.service.Vehicle;

import java.util.List;

import com.architechz.project.packageservices.models.*;
import com.architechz.project.packageservices.payload.InsertionRequest.VehicleRequest;

public interface VehicleService {

    public List<Vehicle> listAllVehicles();
    public Vehicle findById(Long id);
    public abstract String addVehicle(VehicleRequest vehicle);
    public abstract String deleteVehicle(int plate);
    public abstract String updateVehicle(Vehicle vehicle);
    
}
