package com.architechz.project.packageservices.models;


public class Quotation {
    
    private String loadType;
    private City originCity;
    private City destinationCity;
    private float weight;
    private String originDate;
    private String destinationDate;
    private int volume;

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
    public String getOriginDate() {
        return originDate;
    }
    public void setOriginDate(String originDate) {
        this.originDate = originDate;
    }
    public String getDestinationDate() {
        return destinationDate;
    }
    public void setDestinationDate(String destinationDate) {
        this.destinationDate = destinationDate;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public Quotation(String loadType, City originCity, City destinationCity, float weight, String originDate,
            String destinationDate, int volume) {
        this.loadType = loadType;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.weight = weight;
        this.originDate = originDate;
        this.destinationDate = destinationDate;
        this.volume = volume;
    }
    

 


    

}
