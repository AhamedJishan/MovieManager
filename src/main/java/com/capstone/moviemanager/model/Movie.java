package com.capstone.moviemanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    private String tagline;

    @Lob
    private String overview;

    private double revenue;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private MovieStatus status;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
