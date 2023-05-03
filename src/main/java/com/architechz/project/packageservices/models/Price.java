package com.architechz.project.packageservices.models;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_City")
    private City originCity;

    @ManyToOne
    @JoinColumn(name = "destination_City")
    private City destinationCity;

    private int truckType;

    private BigDecimal price;

    public Price(City originCity, City destinationCity, int truckType, BigDecimal price) {
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.truckType = truckType;
        this.price = price;
    }

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getOriginCity() {
        return originCity;
    }

    public void setOriginCity(City originCity) {
        this.originCity = originCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getTruckType() {
        return truckType;
    }

    public void setTruckType(int truckType) {
        this.truckType = truckType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Price(Long id, City originCity, City destinationCity, int truckType, BigDecimal price) {
        this.id = id;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.truckType = truckType;
        this.price = price;
    }

    

   
    

    


    
}
