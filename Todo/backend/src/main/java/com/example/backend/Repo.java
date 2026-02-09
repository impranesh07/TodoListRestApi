package com.example.backend;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface Repo extends MongoRepository<Student , String>{
    //create method for search individual byname,byid,byadd,bydes
    Optional<Student> findByName(String name);

    //create metod not retuen 
    String deleteByname(String name);
}
