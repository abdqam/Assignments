package com.swift.overflow.overflow.repositories;

import com.swift.overflow.overflow.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
    List<Answer> findAll();

}
