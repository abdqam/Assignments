package com.mvc.languages.languages.repositories;

import com.mvc.languages.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    // this method retrieves all the Languages from the database
    List<Language> findAll();
}