package com.architechz.project.packageservices.service.Warehouse;

import com.architechz.project.packageservices.payload.Request.WarehouseRequest;

public interface WarehouseService {
    public abstract String addWarehouse(WarehouseRequest warehouseRequest);
    public abstract String deleteWarehouse(WarehouseRequest warehouseRequest);
    public abstract String editWarehouse(WarehouseRequest warehouseRequest);
}
