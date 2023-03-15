package com.example.prueba.controller;

import com.example.prueba.model.Person;
import com.example.prueba.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    ResponseEntity<Person> save(@RequestBody Person person){
        Person result = service.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
