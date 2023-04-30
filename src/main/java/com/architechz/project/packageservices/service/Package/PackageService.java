package com.architechz.project.packageservices.service.Package;

import java.util.List;

import com.architechz.project.packageservices.models.Package;

public interface PackageService {

    public List<Package> listAllPackages();

    public List<Package> listAllPackagesByDeliveryId(Long id);

    public List<Package> listAllPackagesByIdClient(int id);

}
