package com.architechz.project.packageservices.service.Delivery;

import com.architechz.project.packageservices.enums.Status;
import com.architechz.project.packageservices.models.*;
import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRespository productRespository;

    @Override
    public BigDecimal programDelivery(Long originId,
                                      Long desinationId,
                                      String type,
                                      Date arriveDate,
                                      List<Product> products){

        Optional<City> originCity = cityRepository.findById(originId);
        Optional<City> destinationCity = cityRepository.findById(desinationId);


        List<Warehouse> warehouses = warehouseRepository.findByCityId(originId);
        Warehouse warehouse = warehouses.get(0);

        List<Package> packages = new ArrayList<>();
        BigDecimal totalWeight = BigDecimal.ZERO;
        for (Product product : products) {
            Package packageItem = new Package();
            packageItem.setWeight(product.getWeight());
            packageItem.setType(product.getCategory());
            packageItem.setVolume(product.getVolume());
            packageItem.setLocation(originCity.get().getName());
            packageItem.setWarehouse(warehouse);
            packages.add(packageItem);
            totalWeight = totalWeight.add(BigDecimal.valueOf(product.getWeight()));
        }

        BigDecimal costPerTon = BigDecimal.valueOf(100000);
        BigDecimal travelCost = BigDecimal.valueOf(500000);
        BigDecimal deliveryCost = costPerTon.multiply(totalWeight).add(travelCost);

        Delivery delivery = new Delivery();
        delivery.setOrigin(originCity.get().getName());
        delivery.setDestination(destinationCity.get().getName());
        delivery.setArriveDate(arriveDate);
        delivery.setCostPerTon(costPerTon);
        delivery.setTravelCost(travelCost);
        delivery.setStatus(Status.IN_WAREHOUSE);
        delivery.setType(type);
        delivery.setArticles(packages);

        List<Package> savedPackages = packageRepository.saveAll(packages);
        for (int i = 0; i < savedPackages.size(); i++) {
            savedPackages.get(i).setDelivery(delivery);
            savedPackages.get(i).setDeliveryCost(deliveryCost.divide(BigDecimal.valueOf(savedPackages.size())));
            packages.set(i, savedPackages.get(i)); // actualizar lista original
        }

        delivery = deliveryRepository.save(delivery);
        for (Package packageItem : packages) {
            packageItem = packageRepository.save(packageItem);
        }

        for (Product product : products) {
            Long lastId = productRespository.getLastId(); // Obtener último id guardado
            Long newId = lastId != null ? lastId + 1 : 1; // Sumar uno al último id o asignar 1 si es el primer producto
            product.setId(newId); // Asignar nuevo id al producto
            product.setDelivery(delivery);
            productRespository.save(product);
        }

        return deliveryCost;
    }

    @Override
    public List<Delivery> listAllDeliverys() {
        return this.deliveryRepository.findAll();
    }
}
