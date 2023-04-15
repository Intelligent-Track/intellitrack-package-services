package com.architechz.project.packageservices.service.Delivery;

import com.architechz.project.packageservices.enums.Status;
import com.architechz.project.packageservices.models.*;
import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.repository.CityRepository;
import com.architechz.project.packageservices.repository.DeliveryRepository;
import com.architechz.project.packageservices.repository.PackageRepository;
import com.architechz.project.packageservices.repository.WarehouseRepository;
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

    @Override
    public BigDecimal programDelivery(Long originId,
                                      Long desinationId,
                                      String type,
                                      Date arriveDate,
                                      List<Product> products){

        Optional<City> originCity = cityRepository.findById(originId);
        Optional<City> destinationCity = cityRepository.findById(desinationId);

        Optional<Warehouse> warehouse = warehouseRepository.findById(originId);

        List<Package> packages = new ArrayList<>();
        BigDecimal totalWeight = BigDecimal.ZERO;
        for (Product product : products) {
            Package packageItem = new Package();
            packageItem.setWeight(product.getWeight());
            packageItem.setType(product.getCategory());
            packageItem.setVolume(product.getVolume());
            packageItem.setLocation(originCity.get().getName());
            packageItem.setWarehouse(warehouse.get());
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
        for (Package packageItem : savedPackages) {
            packageItem.setDelivery(delivery);
            packageItem.setDeliveryCost(deliveryCost.divide(BigDecimal.valueOf(savedPackages.size())));
        }

        delivery = deliveryRepository.save(delivery);
        for (Package packageItem : packages) {
            packageItem = packageRepository.save(packageItem);
        }
        return deliveryCost;
    }

    @Override
    public List<Delivery> listAllDeliverys() {
        return this.deliveryRepository.findAll();
    }
}
