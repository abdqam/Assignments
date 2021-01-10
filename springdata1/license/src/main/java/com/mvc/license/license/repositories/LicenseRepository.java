package com.mvc.license.license.repositories;

import com.mvc.license.license.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LicenseRepository extends CrudRepository<License,Long> {
    List<License> findAll();
    License findTopByOrderByNumberDesc();

}
