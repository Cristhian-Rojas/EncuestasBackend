package com.example.prueba.service;


import com.example.prueba.model.User;

public interface UserService {


    User save(User user);

    User findByEmail(String email);

    String findEmail(int id);
}
