package com.architechz.project.packageservices.models;

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
    private String address;

    @NotBlank
    private double capacity;

    @NotBlank
    private String type;

    public Warehouse(@NotBlank String address, @NotBlank double capacity, @NotBlank String type) {
        this.address = address;
        this.capacity = capacity;
        this.type = type;
        this.inventory = new ArrayList<>();
    }

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> inventory;

    public Warehouse() {
        this.inventory = new ArrayList<>();
    }

    public Warehouse(Long id, @NotBlank String address, @NotBlank double capacity, @NotBlank String type) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.type = type;
        this.inventory = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
