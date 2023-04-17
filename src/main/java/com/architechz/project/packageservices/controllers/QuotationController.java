package com.architechz.project.packageservices.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.payload.InsertionRequest.QuotationRequest;

import com.architechz.project.packageservices.service.Quotation.QuotationService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/qte")
public class QuotationController {

    @Autowired
    QuotationService quotationService;

    @GetMapping("/allCities")
    public List<City> getAllCities() {
        return this.quotationService.listAllCities();
    }

    @PostMapping("/quoteDelivery")
    public float getPrice(@Valid @RequestBody QuotationRequest quotationRequest) {
      return quotationService.getPrice(quotationRequest);
    }
    
}
