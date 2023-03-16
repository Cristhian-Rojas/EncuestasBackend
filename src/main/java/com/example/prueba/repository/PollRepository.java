package com.example.prueba.repository;

import com.example.prueba.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PollRepository extends JpaRepository<Poll, Integer> {

    @Query(value = "SELECT p.iduser FROM testfit.polls p WHERE p.emailpoll = :email group by p.emailpoll", nativeQuery = true)
    int findIdByEmail(String email);

}
