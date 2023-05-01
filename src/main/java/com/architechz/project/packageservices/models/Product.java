package com.architechz.project.packageservices.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;

    private String category;
    private double weight;
    private double volume;
    private String name;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Product(String category, double weight, double volume, String name) {
        this.category = category;
        this.weight = weight;
        this.volume = volume;
        this.name = name;
    }

    public Product() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {return volume;}

    public void setVolume(double volume) {this.volume = volume;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

}
