package com.example.prueba.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "polls")
public class Poll {

    @Id
    @Column(name = "id_poll", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nmdocumento", nullable = false)
    private String nmdocumento = String.valueOf(UUID.randomUUID());

    @Column(name = "emailpoll", nullable = false)
    private String emailpoll;

    @Column(name = "comments", nullable = false)
    private String comments;

    @Column(name = "favoritebrand", nullable = false)
    private String favoritebrand;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;



}
