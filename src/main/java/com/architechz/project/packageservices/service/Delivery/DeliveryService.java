package com.architechz.project.packageservices.service.Delivery;

import com.architechz.project.packageservices.models.Delivery;
import com.architechz.project.packageservices.models.Product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface DeliveryService {

    public BigDecimal programDelivery(
            Long originId, Long destinationId, String type, Date arriveDate, List<Product> products);

    public List<Delivery> listAllDeliveries();

    public String deleteDelivery(Delivery delivery);

    public List<Delivery> listAllDeliveriesByIdDriver(Long idDriver);

}
