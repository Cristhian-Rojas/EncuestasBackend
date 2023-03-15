package com.example.prueba.service;

import com.example.prueba.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person save(Person person);

}
