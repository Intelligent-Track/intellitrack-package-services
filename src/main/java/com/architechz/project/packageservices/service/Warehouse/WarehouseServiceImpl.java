package com.architechz.project.packageservices.service.Warehouse;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.architechz.project.packageservices.models.Warehouse;
import com.architechz.project.packageservices.payload.Request.WarehouseRequest;
import com.architechz.project.packageservices.repository.WarehouseRepository;


@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public  String addWarehouse(WarehouseRequest warehouseRequest){
        if (warehouseRepository.existsByAddress(warehouseRequest.getAddress())) {
            return "Error: La bodega con dirección "+ warehouseRequest.getAddress() + " ya existe en nuestras bases de datos!";
        }
        else{
        
            try {

                Warehouse warehouse = new Warehouse(warehouseRequest.getAddress(),warehouseRequest.getCapacity(),warehouseRequest.getType());
                warehouseRepository.save(warehouse);
        
        
                } catch (Exception e) {
                    return e.toString(); 
                }
        
                return "Bodega guardada con exito";
        }
    }

    @Transactional
    public String deleteWarehouse(WarehouseRequest warehouseRequest){
        try {
            
            warehouseRepository.deleteByAddress(warehouseRequest.getAddress());


        } catch (Exception e) {
            return e.toString();// TODO: handle exception
        }


        return "Bodega con dirección " + warehouseRequest.getAddress() +"  ha sido borrada con exito!";


    }

    @Override
    public String editWarehouse(WarehouseRequest warehouseRequest){
        try {
            
            Warehouse warehouse = warehouseRepository.findByAddress(warehouseRequest.getAddress());
            
            warehouse.setCapacity(warehouseRequest.getCapacity());
            warehouse.setType(warehouseRequest.getType());
            warehouseRepository.save(warehouse);

        } catch (Exception e) {
            return e.toString();// TODO: handle exception
        }
        
        return "Usuario actualizado con exito!!";


    }
}
