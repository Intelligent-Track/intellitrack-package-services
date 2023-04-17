package com.architechz.project.packageservices.payload.InsertionRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.models.Type;

import java.math.BigDecimal;

import java.util.List;

public class WarehouseRequest {
    
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NotBlank
    private String address;

    
    private double capacity;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    
    private BigDecimal costPerM3;
    
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> inventory;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getCostPerM3() {
        return costPerM3;
    }

    public void setCostPerM3(BigDecimal costPerM3) {
        this.costPerM3 = costPerM3;
    }

    public List<Package> getInventory() {
        return inventory;
    }

    public void setInventory(List<Package> inventory) {
        this.inventory = inventory;
    }

}
