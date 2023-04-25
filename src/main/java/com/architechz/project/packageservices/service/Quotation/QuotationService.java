package com.architechz.project.packageservices.service.Quotation;


import java.math.BigDecimal;
import java.util.List;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.payload.InsertionRequest.QuotationRequest;


public interface QuotationService {
    public List<City> listAllCities();
    public BigDecimal getPrice(QuotationRequest quotationRequest);
}
