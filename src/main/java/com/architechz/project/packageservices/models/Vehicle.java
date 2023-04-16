package com.architechz.project.packageservices.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        private String name;
    
        private String plate;
    
        private String type;
    
        private double capacity;

        private String region;
    
        private String description;

        
        public Vehicle(String name, String plate, String type,
                double capacity, String region, String description) {
            this.name = name;
            this.plate = plate;
            this.type = type;
            this.capacity = capacity;
            this.region = region;
            this.description = description;
        }

        

        public Vehicle() {
        }



        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getPlate() {
            return plate;
        }
    
        public void setPlate(String plate) {
            this.plate = plate;
        }
    
        public String getType() {
            return type;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        public double getCapacity() {
            return capacity;
        }
    
        public void setCapacity(double capacity) {
            this.capacity = capacity;
        }

        public String getRegion() {
            return region;
        }
    
        public void setRegion(String region) {
            this.region = region;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    }
    



