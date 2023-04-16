package com.architechz.project.packageservices.payload.InsertionRequest;

import javax.validation.constraints.*;


public class VehicleRequest {

        private String model;
    
        private int plate;
    
        private String type;

        private String failureHistory;
    
        private String mechanicHistory;

        private int volumeCapacity;

        private int weightCapacity;

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

