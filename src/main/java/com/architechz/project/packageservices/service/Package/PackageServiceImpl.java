package com.architechz.project.packageservices.service.Package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.models.Package;
import com.architechz.project.packageservices.repository.PackageRepository;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    PackageRepository packageRepository;

    @Override
    public List<Package> listAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public List<Package> listAllPackagesByDeliveryId(Long id) {
        return packageRepository.findAllByDeliveryId(id);
    }

    @Override
    public List<Package> listAllPackagesByIdClient(int id) {
        return packageRepository.findAllByIdClient(id);
    }

}
