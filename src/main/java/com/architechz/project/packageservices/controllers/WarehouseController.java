package com.architechz.project.packageservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Type;
import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.service.Warehouse.WarehouseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ware")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/allCities")
    public List<City> getAllCities() {
        return this.warehouseService.listAllCities();
    }

    @GetMapping("/allTypes")
    public List<Type> getAllTypes() {
        return this.warehouseService.listAllTypes();
    }

    @GetMapping("/warehouse/{id}")
    public Warehouse getWarehouseById(@PathVariable("id") Long id){
        return this.warehouseService.findById(id);
    }

    @GetMapping("/allWarehouses")
    public List<Warehouse> getAllWarehouses() {
        return this.warehouseService.listAllWarehouses();
    }

    @GetMapping("/allWarehousesByCity/{id}")
    public List<Warehouse> getAllWarehousesByCity(@PathVariable("id") Long idCity) {
        return this.warehouseService.listAllWarehousesByCity(idCity);
    }

    @GetMapping("/allWarehousesByType/{id}")
    public List<Warehouse> getAllWarehousesByType(@PathVariable("id") Long idType) {
        return this.warehouseService.listAllWarehousesByType(idType);
    }

    @GetMapping("/allWarehousesByCapacity/{capacity}")
    public List<Warehouse> getAllWarehousesByCapacity(@PathVariable("capacity") double capacity) {
        return this.warehouseService.listAllWarehousesByCapacity(capacity);
    }

}
