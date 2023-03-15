package com.example.prueba.repository;

import com.example.prueba.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {



}
