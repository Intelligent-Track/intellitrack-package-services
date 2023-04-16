package com.architechz.project.packageservices.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.models.Vehicle;
import com.architechz.project.packageservices.payload.InsertionRequest.VehicleRequest;
import com.architechz.project.packageservices.service.*;
import com.architechz.project.packageservices.service.Vehicle.VehicleService;

@RestController
@RequestMapping("/api/vehi")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/allVehicles")
    public List<Vehicle> getAllvehicles() {
        return vehicleService.listAllVehicles();
    }

    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id){
        return this.vehicleService.findById(id);
    }
    
    @PostMapping("/VehicleCreate")
    public ResponseEntity<?> VehicleCreate(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return ResponseEntity.ok().body(vehicleService.addVehicle(vehicleRequest));
    }

    @DeleteMapping("/VehicleDelete/{id}")
    public ResponseEntity<?> VehicleDelete(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return ResponseEntity.ok().body(vehicleService.deleteVehicle(vehicleRequest));
    }


}
