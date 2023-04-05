package com.architechz.project.packageservices.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.architechz.project.packageservices.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @NotBlank
    private Date departureDate;

    @NotBlank
    private BigDecimal costPerTon;

    @NotBlank
    private BigDecimal travelCost;

    @NotBlank
    private Status status;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> articles;

    public Delivery() {
    }

    public Delivery(Long id, @NotBlank String origin, @NotBlank String destination, @NotBlank Date departureDate,
            @NotBlank BigDecimal costPerTon, @NotBlank BigDecimal travelCost, @NotBlank Status status) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.costPerTon = costPerTon;
        this.travelCost = travelCost;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public BigDecimal getCostPerTon() {
        return costPerTon;
    }

    public void setCostPerTon(BigDecimal costPerTon) {
        this.costPerTon = costPerTon;
    }

    public BigDecimal getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(BigDecimal travelCost) {
        this.travelCost = travelCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
