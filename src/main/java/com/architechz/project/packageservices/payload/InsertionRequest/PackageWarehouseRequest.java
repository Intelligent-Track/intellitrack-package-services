package com.architechz.project.packageservices.payload.InsertionRequest;

import java.util.List;

import com.architechz.project.packageservices.models.Package;

public class PackageWarehouseRequest {

    private long warehouseId;

    private List<Package> packages;

    public PackageWarehouseRequest() {
    }

    public PackageWarehouseRequest(long warehouseId, List<Package> packages) {
        this.warehouseId = warehouseId;
        this.packages = packages;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

}
