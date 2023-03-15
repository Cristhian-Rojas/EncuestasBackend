package com.example.prueba.service;

import com.example.prueba.model.Poll;
import com.example.prueba.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {

    private final PollRepository repo;

    @Override
    public List<Poll> findAll() {
        return repo.findAll();
    }

    @Override
    public Poll save(Poll poll) {
        return repo.saveAndFlush(poll);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public Poll findById(int id) {
        return repo.findById(id).orElse(null);
    }


}

