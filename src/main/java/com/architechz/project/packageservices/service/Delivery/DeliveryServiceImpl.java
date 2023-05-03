package com.architechz.project.packageservices.service.Delivery;

import com.architechz.project.packageservices.enums.Status;
import com.architechz.project.packageservices.models.*;
import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
            Long destinationId,
            String type,
            Date arriveDate,
            Date departureDate,
            String comments,
            String nit,
            List<Product> products) {

        Optional<City> originCity = cityRepository.findById(originId);
        Optional<City> destinationCity = cityRepository.findById(destinationId);

        List<Warehouse> warehouse = warehouseRepository.findByCityId(originId);

        if (warehouse.isEmpty()) {
            return null;
        }

        double totalWeight = 0;
        double totalVolume = 0;

        List<Package> packages = new ArrayList<>();

        for (Product product : products) {
            totalWeight = totalWeight + product.getWeight();
            totalVolume = totalVolume + product.getVolume();

            Package packageItem = new Package();
            packageItem.setWeight(product.getWeight());
            packageItem.setType(product.getCategory());
            packageItem.setVolume(product.getVolume());
            packageItem.setLocation(originCity.get().getName());
            packageItem.setWarehouse(warehouse.get(0));
            packages.add(packageItem);
        }

        BigDecimal costPerTon = BigDecimal.valueOf(100000);
        BigDecimal deliveryCost = BigDecimal.valueOf(500000);
        BigDecimal travelCost = costPerTon.multiply(BigDecimal.valueOf(totalWeight)).add(deliveryCost);

        int number = generateRandomNumber(0, 20);
        Delivery delivery = new Delivery();
        delivery.setOrigin(originCity.get().getName());
        delivery.setDestination(destinationCity.get().getName());
        delivery.setArriveDate(arriveDate);
        delivery.setDepartureDate(departureDate);
        delivery.setIdDriver((long) number);
        delivery.setNit(nit);
        delivery.setCostPerTon(costPerTon);
        delivery.setTravelCost(travelCost);
        delivery.setStatus(Status.IN_WAREHOUSE);
        delivery.setType(type);
        delivery.setComments(comments);
        delivery.setArticles(packages);

        List<Package> savedPackages = packageRepository.saveAll(packages);
        BigDecimal packageDeliveryCost = deliveryCost.divide(BigDecimal.valueOf(savedPackages.size()));
        for (int i = 0; i < savedPackages.size(); i++) {
            Package savedPackage = savedPackages.get(i);
            savedPackage.setDelivery(delivery);
            savedPackage.setDeliveryCost(packageDeliveryCost);
            packages.set(i, savedPackage);
        }

        delivery = deliveryRepository.save(delivery);

        for (Package packageItem : packages) {
            packageRepository.save(packageItem);
        }

        for (Product product : products) {
            Long lastId = productRespository.getLastId();
            Long newId = (lastId != null ? lastId + 1 : 1);
            product.setId(newId);
            product.setDelivery(delivery);
            productRespository.save(product);
        }

        return travelCost;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public String deleteDelivery(Long deliveryId) {
        try {

            deliveryRepository.deleteById(deliveryId);

        } catch (Exception e) {
            return e.toString();
        }

        return "Envío con id ha sido borrado con exito!";

    }

    @Override
    public String editDelivery(Delivery delivery) {
        if (delivery.getStatus() != Status.IN_WAREHOUSE) {
            return "Error: El envio con id " + delivery.getId()
                    + " se encuantra en un estado diderente a IN_WAREHOUSE!";
        } else {
            try {

                Delivery deliveryEdited = this.findById(delivery.getId());

                deliveryEdited.setArriveDate(delivery.getArriveDate());
                deliveryEdited.setDepartureDate(delivery.getDepartureDate());
                deliveryEdited.setComments(delivery.getComments());

                deliveryRepository.save(deliveryEdited);

            } catch (Exception e) {
                return e.toString();
            }

            return "Envio actualizada con exito!!";
        }

    }

    @Override
    public List<Delivery> listAllDeliveries() {
        return this.deliveryRepository.findAll();
    }

    @Override
    public List<Delivery> listAllDeliveriesByIdDriver(Long idDriver) {
        return this.deliveryRepository.findAllDeliveriesByIdDriver(idDriver);
    }

    @Override
    public List<Delivery> listAllDeliveriesByIdDriverInWarehouse(Long idDriver) {
        Status status = Status.IN_WAREHOUSE;
        return deliveryRepository.findAllDeliveriesByIdDriverAndStatus(idDriver, status);
    }

    @Override
    public List<Delivery> listAllDeliveriesByIdDriverOnTheWay(Long idDriver) {
        Status status = Status.ON_THE_WAY;
        return deliveryRepository.findAllDeliveriesByIdDriverAndStatus(idDriver, status);
    }

    @Override
    public List<Delivery> listAllDeliveriesByIdDriverDelivered(Long idDriver) {
        Status status = Status.DELIVERED;
        return deliveryRepository.findAllDeliveriesByIdDriverAndStatus(idDriver, status);
    }

    @Override
    public List<Delivery> listAllDeliveriesInWarehouse(String nit) {
        List<Delivery> allDeliveriesByNit = this.getAllDeliveriesByNit(nit);
        List<Delivery> deliveriesInWarehouse = new ArrayList<>();

        for (Delivery delivery : allDeliveriesByNit) {
            if (delivery.getStatus().equals(Status.IN_WAREHOUSE)) {
                deliveriesInWarehouse.add(delivery);
            }
        }

        return deliveriesInWarehouse;
    };

    @Override
    public List<Delivery> listAllDeliveriesOnTheWay(String nit) {
        List<Delivery> allDeliveriesByNit = this.getAllDeliveriesByNit(nit);
        List<Delivery> deliveriesInWarehouse = new ArrayList<>();

        for (Delivery delivery : allDeliveriesByNit) {
            if (delivery.getStatus().equals(Status.ON_THE_WAY)) {
                deliveriesInWarehouse.add(delivery);
            }
        }

        return deliveriesInWarehouse;
    };

    @Override
    public List<Delivery> listAllDeliveriesDelivered(String nit) {
        List<Delivery> allDeliveriesByNit = this.getAllDeliveriesByNit(nit);
        List<Delivery> deliveriesInWarehouse = new ArrayList<>();

        for (Delivery delivery : allDeliveriesByNit) {
            if (delivery.getStatus().equals(Status.DELIVERED)) {
                deliveriesInWarehouse.add(delivery);
            }
        }

        return deliveriesInWarehouse;
    };

    @Override
    public Delivery findById(Long id) {
        return this.deliveryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Delivery> getAllDeliveriesByNit(String nit) {
        return this.deliveryRepository.findAllDeliveriesByNit(nit);
    }
}
