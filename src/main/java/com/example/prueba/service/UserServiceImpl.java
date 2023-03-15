package com.example.prueba.service;

import com.example.prueba.model.User;
import com.example.prueba.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public User save(User user) {
        return repo.saveAndFlush(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public String findEmail(int id) {
        return repo.findEmail(id);
    }
}
