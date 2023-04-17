package com.architechz.project.packageservices.models;


public class Quotation {
    
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
    public Quotation(String loadType, City originCity, City destinationCity, float weight, String date) {
        this.loadType = loadType;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.weight = weight;
        this.date = date;
    }
    public Quotation() {
    }


    

}
