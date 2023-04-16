package com.architechz.project.packageservices.controllers;

import com.architechz.project.packageservices.models.Product;
import com.architechz.project.packageservices.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/productsByDeliveryId/{id}")
    public List<Product> getAllProductsByDeliveryId(@PathVariable Long id) {
        return productService.listAllProductsByDeliveryId(id);
    }

}
