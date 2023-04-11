package com.architechz.project.packageservices.service.Warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.repository.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> listAllWarehouses() {
        return this.warehouseRepository.findAll();
    }

    @Override
    public List<Warehouse> listAllWarehousesByCity(String city) {
        return this.warehouseRepository.findByCity(city);
    }

    @Override
    public List<Warehouse> listAllWarehousesByType(String type) {
        return this.warehouseRepository.findByType(type);
    }

    @Override
    public List<Warehouse> listAllWarehousesByCapacity(double capacity) {
        List<Warehouse> warehouses = this.warehouseRepository.findAll();
        List<Warehouse> searchWarehouses = new ArrayList<>();
        for(Warehouse warehouse : warehouses){
            if(warehouse.getCapacity() >= capacity){
                searchWarehouses.add(warehouse);
            }
        }
        return searchWarehouses;
    }
    
}
