package com.dojoandninjas.mvc.dojoandninjas.repositories;

import com.dojoandninjas.mvc.dojoandninjas.models.Dojo;
import com.dojoandninjas.mvc.dojoandninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long> {
    List<Ninja> findAll();
}
