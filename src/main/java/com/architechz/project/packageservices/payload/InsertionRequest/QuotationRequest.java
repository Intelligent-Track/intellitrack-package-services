package com.architechz.project.packageservices.payload.InsertionRequest;


import com.architechz.project.packageservices.models.City;

public class QuotationRequest {
    
    private String loadType;
    private City originCity;
    private City destinationCity;
    private float weight;
    private String date;

    public String getLoadType() {
        return loadType;
    }
    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }
    public City getOriginCity() {
        return originCity;
    }
    public void setOriginCity(City originCity) {
        this.originCity = originCity;
    }
    public City getDestinationCity() {
        return destinationCity;
    }
    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
