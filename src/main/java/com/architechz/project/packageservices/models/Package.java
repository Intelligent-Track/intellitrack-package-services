package com.architechz.project.packageservices.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight;

    private double volume;

    @NotBlank
    private String location;

    @NotBlank
    private String type;

    @NotNull
    private int idClient;

    @ManyToOne
    @JsonIgnore
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Package() {
    }

    public Package(Long id, double weight, double volume, @NotBlank String location,
            @NotBlank String type) {
        this.id = id;
        this.weight = weight;
        this.volume = volume;
        this.location = location;
        this.type = type;
    }

    public Package(Long id, double weight, double volume, @NotBlank String location, @NotBlank String type,
            @NotBlank int idClient) {
        this.id = id;
        this.weight = weight;
        this.volume = volume;
        this.location = location;
        this.type = type;
        this.idClient = idClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setDeliveryCost(BigDecimal divide) {
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
