package com.architechz.project.packageservices.payload.InsertionRequest;

import com.architechz.project.packageservices.models.City;

public class QuotationRequest {

    private String loadType;
    private City originCity;
    private City destinationCity;
    private float weight;
    private int volume;
    private String dateArrive;
    private String dateDeparture;
    
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
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public String getDateArrive() {
        return dateArrive;
    }
    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }
    public String getDateDeparture() {
        return dateDeparture;
    }
    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }
 
}
