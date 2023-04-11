package com.architechz.project.packageservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.service.Warehouse.WarehouseService;

@RestController
@RequestMapping("/api/ware")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/allWarehouses")
    public List<Warehouse> getAllWarehouses() {
        return this.warehouseService.listAllWarehouses();
    }

    @GetMapping("/allWarehousesByCity")
    public List<Warehouse> getAllWarehousesByCity(String city) {
        return this.warehouseService.listAllWarehousesByCity(city);
    }

    @GetMapping("/allWarehousesByType")
    public List<Warehouse> getAllWarehousesByType(String type) {
        return this.warehouseService.listAllWarehousesByType(type);
    }

    @GetMapping("/allWarehousesByCapacity")
    public List<Warehouse> getAllWarehousesByCapacity(double capacity) {
        return this.warehouseService.listAllWarehousesByCapacity(capacity);
    }

}
