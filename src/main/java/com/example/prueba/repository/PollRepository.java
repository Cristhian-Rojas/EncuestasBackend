package com.example.prueba.repository;

import com.example.prueba.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PollRepository extends JpaRepository<Poll, Integer> {




}
