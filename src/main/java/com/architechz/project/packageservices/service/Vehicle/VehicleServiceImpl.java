package com.architechz.project.packageservices.service.Vehicle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.controllers.VehicleController;
import com.architechz.project.packageservices.models.*;
import com.architechz.project.packageservices.payload.InsertionRequest.VehicleRequest;
import com.architechz.project.packageservices.repository.*;
import com.architechz.project.packageservices.service.*;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> listAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return this.vehicleRepository.findById(id).orElseThrow();
    }

    @Override
    public String addVehicle(VehicleRequest vehicle) {
        if (vehicleRepository.existsByPlate(vehicle.getPlate())) {
            return "Error: La placa " + vehicle.getPlate() + " ya existe en nuestras bases de datos!";
        } else {
            try {
                Vehicle newVehicle = new Vehicle(vehicle.getPlate(), vehicle.getName(), vehicle.getType(), vehicle.getCapacity(), vehicle.getRegion(), vehicle.getDescription());
                vehicleRepository.save(newVehicle);
            } catch (Exception e) {
                return e.toString();
            }
            return "Vehículo guardado con éxito";
        }
    }

    @Override
    public String deleteVehicle(VehicleRequest vehicle) {
        if (vehicleRepository.existsByPlate(vehicle.getPlate())) {
            try {
                vehicleRepository.deleteByPlate(vehicle.getPlate());
            } catch (Exception e) {
                return e.toString();
            }
            return "Vehículo eliminado con éxito";
        } else {
            return "Error: La placa " + vehicle.getPlate() + " no existe en nuestras bases de datos";
        }
    }

    @Override
    public String updateVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateVehicle'");
    }


    
    

}
