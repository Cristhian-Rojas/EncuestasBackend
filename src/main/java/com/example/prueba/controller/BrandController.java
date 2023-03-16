package com.example.prueba.controller;

import com.example.prueba.model.Brand;
import com.example.prueba.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    ResponseEntity<List<Brand>> get(){
        return ResponseEntity.ok(brandService.findAll());
    }

}
