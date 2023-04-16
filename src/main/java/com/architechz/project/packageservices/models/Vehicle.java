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

        private String model;
    
        private int plate;
    
        private String type;

        private String failureHistory;
    
        private String mechanicHistory;

        private int volumeCapacity;

        private int weightCapacity;

        public Vehicle(String model, int plate, String type, String failureHistory, String mechanicHistory,
                int volumeCapacity, int weightCapacity) {
            this.model = model;
            this.plate = plate;
            this.type = type;
            this.failureHistory = failureHistory;
            this.mechanicHistory = mechanicHistory;
            this.volumeCapacity = volumeCapacity;
            this.weightCapacity = weightCapacity;
        }

        public Vehicle() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPlate() {
            return plate;
        }

        public void setPlate(int plate) {
            this.plate = plate;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFailureHistory() {
            return failureHistory;
        }

        public void setFailureHistory(String failureHistory) {
            this.failureHistory = failureHistory;
        }

        public String getMechanicHistory() {
            return mechanicHistory;
        }

        public void setMechanicHistory(String mechanicHistory) {
            this.mechanicHistory = mechanicHistory;
        }

        public int getVolumeCapacity() {
            return volumeCapacity;
        }

        public void setVolumeCapacity(int volumeCapacity) {
            this.volumeCapacity = volumeCapacity;
        }

        public int getWeightCapacity() {
            return weightCapacity;
        }

        public void setWeightCapacity(int weightCapacity) {
            this.weightCapacity = weightCapacity;
        }

        

        

        

        
    

        
        
    }
    



