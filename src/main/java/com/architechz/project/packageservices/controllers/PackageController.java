package com.architechz.project.packageservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.service.Package.PackageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pack")
public class PackageController {

    @Autowired
    PackageService packageService;

    @GetMapping("/allPackages")
    public List<Package> getAllPackages() {
        return packageService.listAllPackages();
    }

    @GetMapping("/packagesByDeliveryId/{id}")
    public List<Package> getAllPackagesByDeliveryId(@PathVariable Long id) {
        return packageService.listAllPackagesByDeliveryId(id);
    }

    @GetMapping("/packagesByClientId/{id}")
    public List<Package> getAllPackagesByClientId(@PathVariable int id) {
        return packageService.listAllPackagesByIdClient(id);
    }

}
