package com.architechz.project.packageservices.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Type;
import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.payload.InsertionRequest.WarehouseRequest;
import com.architechz.project.packageservices.payload.response.MessageResponse;
import com.architechz.project.packageservices.service.Warehouse.WarehouseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ware")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/warehouseCreate")
    public ResponseEntity<?> addWarehouse(@Valid @RequestBody WarehouseRequest warehouseRequest) {
      return ResponseEntity.ok().body(warehouseService.addWarehouse(warehouseRequest));
    }

    @DeleteMapping("/deleteWarehouse")
    public ResponseEntity<?> deleteWarehouse(@Valid @RequestBody WarehouseRequest warehouseRequest) {
      return ResponseEntity.ok(new MessageResponse(warehouseService.deleteWarehouse(warehouseRequest)));
    }
    
    @PutMapping("/updateWarehouse")
    public ResponseEntity<?> editWarehouse(@Valid @RequestBody Warehouse warehouse) {
      return ResponseEntity.ok(new MessageResponse(warehouseService.editWarehouse(warehouse)));
    }

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
