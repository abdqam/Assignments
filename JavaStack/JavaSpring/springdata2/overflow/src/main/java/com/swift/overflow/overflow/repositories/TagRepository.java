package com.swift.overflow.overflow.repositories;

import com.swift.overflow.overflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
    List<Tag> findAll();
    Tag findBySubject(String string);
}
