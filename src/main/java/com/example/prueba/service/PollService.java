package com.example.prueba.service;

import com.example.prueba.model.Poll;

import java.util.List;

public interface PollService {

    List<Poll> findAll();

    Poll save(Poll poll);

    void delete(int id);

    Poll findById(int id);

    int findIdByEmail(String email);

}
