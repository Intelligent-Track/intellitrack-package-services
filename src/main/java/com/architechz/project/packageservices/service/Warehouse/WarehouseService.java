package com.architechz.project.packageservices.service.Warehouse;

import java.util.List;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.models.Type;
import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.payload.InsertionRequest.WarehouseRequest;

public interface WarehouseService {

    public String addWarehouse(WarehouseRequest warehouseRequest);

    public String deleteWarehouse(WarehouseRequest warehouseRequest);

    public boolean deleteWarehouseById(Long id);

    public String editWarehouse(Warehouse warehouse);

    public List<City> listAllCities();

    public List<Type> listAllTypes();

    public Warehouse findById(Long id);

    public List<Warehouse> listAllWarehouses();

    public List<Warehouse> listAllWarehousesByCity(Long idCity);

    public List<Warehouse> listAllWarehousesByType(Long idType);

    public List<Warehouse> listAllWarehousesByCapacity(double capacity);

    public List<Package> listAllPackageinWarehouse(Long id);

    public void addPackageInWarehouse(Long wareId, List<Package> packs);

    public boolean deletePackageInWarehouse(Long wareId, Long packId);

}
