package com.architechz.project.packageservices.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private double weight;

    @NotBlank
    private double volume;

    @NotBlank
    private String location;

    @NotBlank
    private String type;

    @ManyToOne
    @JsonIgnore
    private Warehouse warehouse;

    @ManyToOne
    @JsonIgnore
    private Delivery delivery;

    public Package() {
    }

    public Package(Long id, @NotBlank double weight, @NotBlank double volume, @NotBlank String location,
            @NotBlank String type) {
        this.id = id;
        this.weight = weight;
        this.volume = volume;
        this.location = location;
        this.type = type;
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

}
