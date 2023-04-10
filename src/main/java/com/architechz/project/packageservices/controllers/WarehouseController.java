package com.architechz.project.packageservices.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.payload.Request.WarehouseRequest;
import com.architechz.project.packageservices.payload.Response.MessageResponse;
import com.architechz.project.packageservices.service.Warehouse.WarehouseService;


@RestController
@RequestMapping("/api/ware")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/WarehouseCreate")
    public ResponseEntity<?> addWarehouse(@Valid @RequestBody WarehouseRequest warehouseRequest) {
      return ResponseEntity.ok(new MessageResponse(warehouseService.addWarehouse(warehouseRequest)));
    }

    @DeleteMapping("/DeleteWarehouse/{Adress}")
    public ResponseEntity<?> deleteWarehouse(@Valid @RequestBody WarehouseRequest warehouseRequest) {
      return ResponseEntity.ok(new MessageResponse(warehouseService.deleteWarehouse(warehouseRequest)));
    }
    
    @PutMapping("/UpdateWarehouse")
    public ResponseEntity<?> editWarehouse(@Valid @RequestBody WarehouseRequest warehouseRequest) {
      return ResponseEntity.ok(new MessageResponse(warehouseService.editWarehouse(warehouseRequest)));
    }
}
   