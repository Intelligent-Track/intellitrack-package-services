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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    private Date departureDate;

    private Date arriveDate;

    @NotBlank
    private String type;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal costPerTon;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal travelCost;

    @NotNull
    private Status status;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> articles;

    @NotNull
    private Long idDriver;

    public Delivery() {
    }

    public Delivery(Long id, @NotBlank String origin, @NotBlank String destination, @NotNull Date departureDate,
            @NotNull Date arriveDate,
            BigDecimal costPerTon, BigDecimal travelCost, @NotNull Status status, @NotBlank String type,
            @NotNull Long idDriver) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.costPerTon = costPerTon;
        this.travelCost = travelCost;
        this.status = status;
        this.type = type;
        this.idDriver = idDriver;
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

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Package> getArticles() {
        return articles;
    }

    public void setArticles(List<Package> articles) {
        this.articles = articles;
    }

    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

}
