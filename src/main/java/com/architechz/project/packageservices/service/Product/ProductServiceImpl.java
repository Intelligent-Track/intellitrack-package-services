package com.architechz.project.packageservices.service.Product;

import com.architechz.project.packageservices.models.Product;
import com.architechz.project.packageservices.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRespository productRespository;

    public List<Product> listAllProductsByDeliveryId(Long id) {
        return productRespository.findAllByDeliveryId(id);
    }
}
