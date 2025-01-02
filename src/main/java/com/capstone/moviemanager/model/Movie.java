package com.capstone.moviemanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "MOVIE_ACTOR",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable (name = "MOVIE_GENRE",
                joinColumns        = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
}
