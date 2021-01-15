package com.swift.abdusalam.controllerandviews.repositories;

import com.swift.abdusalam.controllerandviews.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}