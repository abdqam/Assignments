package com.mvc.license.license.repositories;

import com.mvc.license.license.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    List<Person> findAll();

    @Query(value = "SELECT * FROM persons WHERE persons.id not IN ( SELECT licenses.person_id FROM licenses)",nativeQuery = true)
    List<Person> unlicensedPersons();
}
