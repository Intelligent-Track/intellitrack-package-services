package com.architechz.project.packageservices.service.Warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Type;
import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.repository.CityRepository;
import com.architechz.project.packageservices.repository.TypeRepository;
import com.architechz.project.packageservices.repository.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<Type> listAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Warehouse findById(Long id) {
        return this.warehouseRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Warehouse> listAllWarehouses() {
        return this.warehouseRepository.findAll();
    }

    @Override
    public List<Warehouse> listAllWarehousesByCity(Long idCity) {
        return this.warehouseRepository.findByCityId(idCity);
    }

    @Override
    public List<Warehouse> listAllWarehousesByType(Long idType) {
        return this.warehouseRepository.findByTypeId(idType);
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
