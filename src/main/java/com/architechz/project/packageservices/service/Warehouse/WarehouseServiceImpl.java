package com.architechz.project.packageservices.service.Warehouse;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.models.Type;
import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.payload.InsertionRequest.WarehouseRequest;
import com.architechz.project.packageservices.repository.CityRepository;
import com.architechz.project.packageservices.repository.PackageRepository;
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

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public String addWarehouse(WarehouseRequest warehouseRequest) {
        if (warehouseRepository.existsByAddress(warehouseRequest.getAddress())) {
            return "Error: La bodega con dirección " + warehouseRequest.getAddress()
                    + " ya existe en nuestras bases de datos!";
        } else {

            try {

                Warehouse warehouse = new Warehouse(

                        warehouseRequest.getCity(),
                        warehouseRequest.getAddress(),
                        warehouseRequest.getCapacity(),
                        warehouseRequest.getType(),
                        warehouseRequest.getCostPerM3());
                warehouseRepository.save(warehouse);

            } catch (Exception e) {
                return e.toString();
            }

            return "Bodega guardada con dirección" + warehouseRequest.getAddress() + "con exito";
        }
    }

    @Transactional
    public String deleteWarehouse(WarehouseRequest warehouseRequest) {
        try {

            warehouseRepository.deleteByAddress(warehouseRequest.getAddress());

        } catch (Exception e) {
            return e.toString();
        }

        return "Bodega con dirección " + warehouseRequest.getAddress() + "  ha sido borrada con exito!";

    }

    @Override
    public String editWarehouse(Warehouse warehouse) {
        try {

            Warehouse warehouseEdited = this.findById(warehouse.getId());

            warehouseEdited.setCity(warehouse.getCity());
            warehouseEdited.setAddress(warehouse.getAddress());
            warehouseEdited.setCapacity(warehouse.getCapacity());
            warehouseEdited.setType(warehouse.getType());
            warehouseEdited.setCostPerM3(warehouse.getCostPerM3());
            warehouseEdited.setInventory(warehouse.getInventory());

            for (Package packs : warehouse.getInventory()) {
                if (!packageRepository.existsByType(packs.getType())) {
                    packs.setWarehouse(warehouseEdited);
                    packageRepository.save(packs);
                }
            }

            warehouseRepository.save(warehouseEdited);

        } catch (Exception e) {
            return e.toString();
        }

        return "Bodega actualizada con exito!!";

    }

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
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getCapacity() >= capacity) {
                searchWarehouses.add(warehouse);
            }
        }
        return searchWarehouses;
    }

}
