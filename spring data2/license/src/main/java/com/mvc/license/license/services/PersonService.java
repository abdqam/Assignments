package com.mvc.license.license.services;


import com.mvc.license.license.models.Person;
import com.mvc.license.license.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allPerson() {
        return personRepository.findAll();
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalSong = personRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public Person createPerson(Person song) {
        return personRepository.save(song);
    }
    public List<Person> unlicensedPersons() {
        return personRepository.unlicensedPersons();
    }
}