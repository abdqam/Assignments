package com.swift.overflow.overflow.repositories;

import com.swift.overflow.overflow.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
    List<Question> findAll();

}
