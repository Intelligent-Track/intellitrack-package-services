package com.architechz.project.packageservices.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @NotBlank
    private double capacity;

    @NotBlank
    private String type;

    @NotBlank
    private BigDecimal costPerM3;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> inventory;

    public Warehouse() {
        this.inventory = new ArrayList<>();
    }

    public Warehouse(Long id, @NotBlank String city, @NotBlank String address, @NotBlank double capacity,
            @NotBlank String type, @NotBlank BigDecimal costPerM3) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.capacity = capacity;
        this.type = type;
        this.costPerM3 = costPerM3;
        this.inventory = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
