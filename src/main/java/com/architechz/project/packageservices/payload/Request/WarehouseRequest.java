package com.architechz.project.packageservices.payload.Request;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class WarehouseRequest {
    
    @NotBlank
    private String address;

    @NotBlank
    private double capacity;

    @NotBlank
    private String type;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> inventory;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Package> getInventory() {
        return inventory;
    }

    public void setInventory(List<Package> inventory) {
        this.inventory = inventory;
    }

}
