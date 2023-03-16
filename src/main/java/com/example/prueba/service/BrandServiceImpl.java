package com.example.prueba.service;

import com.example.prueba.model.Brand;
import com.example.prueba.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repo;

    @Override
    public List<Brand> findAll() {
        return repo.findAll();
    }
}
