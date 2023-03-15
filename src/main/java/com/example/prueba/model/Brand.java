package com.example.prueba.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "brands")
public class Brand {

    @Id
    @Column(name = "id_brand", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;



}
