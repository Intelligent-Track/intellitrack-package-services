package com.architechz.project.packageservices.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    public Warehouse() {
        this.inventory = new ArrayList<>();
    }

    public Warehouse(@NotBlank City city, @NotBlank String address,double capacity,
            @NotBlank Type type, @NotBlank BigDecimal costPerM3) {
        this.city = city;
        this.address = address;
        this.capacity = capacity;
        this.type = type;
        this.costPerM3 = costPerM3;
        this.inventory = new ArrayList<>();
    }

    public Warehouse(Long id, @NotBlank City city, @NotBlank String address, @NotBlank double capacity,
            @NotBlank Type type, @NotBlank BigDecimal costPerM3) {
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

    public boolean hasEnoughSpace(List<Package> packages) {
        double totalVolume = 0;
        for (Package p : packages) {
            totalVolume += p.getVolume();
        }
        double availableSpace = this.capacity - totalVolume;
        return availableSpace > 0;
    }

    private double getOccupiedSpace() {
        double occupation = 0;
        for (Package p : inventory) {
            occupation += p.getVolume();
        }
        return occupation;
    }
}
