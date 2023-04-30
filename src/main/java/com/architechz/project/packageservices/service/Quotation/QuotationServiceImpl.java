package com.architechz.project.packageservices.service.Quotation;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Price;
import com.architechz.project.packageservices.payload.InsertionRequest.QuotationRequest;
import com.architechz.project.packageservices.repository.CityRepository;
import com.architechz.project.packageservices.repository.PriceRepository;

@Service
public class QuotationServiceImpl implements QuotationService {


    @Autowired
    CityRepository cityRepository;

    @Autowired
    PriceRepository priceRepository;



    @Override
    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public BigDecimal getPrice(QuotationRequest quotationRequest){

        float cost;
        int hoursWaitting=10;
        float costPerTon;
        int aditionalCost=1;
        int truckTypeFactor=1;
        float costoRuta=(float)0;
        float tax;
        int truckType=1;
       
        Float weigh=quotationRequest.getWeight();
        

        if(weigh<=18) {
            truckTypeFactor = 9;
            aditionalCost = 1817;
            truckType=3;

        }
        else if(weigh<=25) {
            truckTypeFactor = 16;
            aditionalCost =  1422;
            truckType=2;
        }
        else if(weigh<31) {
            truckTypeFactor = 34;
            aditionalCost =  812;
            truckType= 1;
        }

        List<Price> prices=priceRepository.findByTruckType(truckType);
        for (Price price : prices) {
            if(price.getOriginCity().getId()==quotationRequest.getOriginCity().getId()){
                if(price.getDestinationCity().getId()==quotationRequest.getDestinationCity().getId())
                    costoRuta=price.getPrice().floatValue();
            }
                
        }
        
        costPerTon= costoRuta+(aditionalCost*hoursWaitting);
        cost=costPerTon*truckTypeFactor*(weigh);
        tax=(cost*6)/100;// Freight transportation taxes are 6% on the original cost
        System.out.println(tax);
        cost+= tax;
        return BigDecimal.valueOf(cost);

    }

    
}


