package com.architechz.project.packageservices.service.Delivery;

import com.architechz.project.packageservices.models.Delivery;
import com.architechz.project.packageservices.models.Product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface DeliveryService {

    public BigDecimal programDelivery(
            Long originId, Long destinationId, String type, Date arriveDate, Date departureDate, String comments, List<Product> products);

    public List<Delivery> listAllDeliveries();

    public String deleteDelivery(Delivery delivery);

    public List<Delivery> listAllDeliveriesByIdDriver(Long idDriver);

    public List<Delivery> getAllDeliveriesByNit(String nit);
    
    public Delivery findById(Long id);

    public String editDelivery(Delivery delivery);

    public List<Delivery> listAllDeliveriesInWarehouse(String nit);
    
    public List<Delivery> listAllDeliveriesOnTheWay(String nit);
    
    public List<Delivery> listAllDeliveriesDelivered(String nit);

}
