package com.architechz.project.packageservices.service.Product;

import com.architechz.project.packageservices.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAllProductsByDeliveryId(Long id);

}
