package com.architechz.project.packageservices.service.Warehouse;

import java.util.List;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Type;
import com.architechz.project.packageservices.models.Warehouse;

public interface WarehouseService {
    
    public List<City> listAllCities();
    public List<Type> listAllTypes();
    public Warehouse findById(Long id);
    public List<Warehouse> listAllWarehouses();
    public List<Warehouse> listAllWarehousesByCity(Long idCity);
    public List<Warehouse> listAllWarehousesByType(Long idType);
    public List<Warehouse> listAllWarehousesByCapacity(double capacity);

}
