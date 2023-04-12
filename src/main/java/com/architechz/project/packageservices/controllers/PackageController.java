package com.architechz.project.packageservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.service.Package.PackageService;

@RestController
@RequestMapping("/api/pack")
public class PackageController {

    @Autowired
    PackageService packageService;

    @GetMapping("/allPackages")
    public List<Package> getAllPackages() {
        return packageService.listAllPackages();
    }
    
}
