package com.mvc.license.license.services;

import com.mvc.license.license.models.License;
import com.mvc.license.license.models.Person;
import com.mvc.license.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    public List<License> allLicense() {
        return licenseRepository.findAll();
    }

    public License findLicense(Long id) {
        Optional<License> optionalSong = licenseRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public License createLicense(License license) {
        return licenseRepository.save(license);
    }
    public License createLicenseWithPerson(License license, Person person) {
        license.setPerson(person);
        license.setNumber(this.num());
       return licenseRepository.save(license);
    }
    public int num(){
        License l = licenseRepository.findTopByOrderByNumberDesc();
        if(l.getNumber()== null){
            return 1;
        }
        int number = l.getNumber();
        number++;
        return number;
    }
}

