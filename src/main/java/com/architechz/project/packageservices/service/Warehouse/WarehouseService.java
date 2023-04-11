package com.architechz.project.packageservices.service.Warehouse;

import java.util.List;

import com.architechz.project.packageservices.models.Warehouse;

public interface WarehouseService {
    
    public List<Warehouse> listAllWarehouses();
    public List<Warehouse> listAllWarehousesByCity(String city);
    public List<Warehouse> listAllWarehousesByType(String type);
    public List<Warehouse> listAllWarehousesByCapacity(double capacity);

}
