package com.capstone.moviemanager.dto;

import com.capstone.moviemanager.model.MovieStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MovieDto {

    private int id;
    private String title;
    private String tagline;
    private String overview;
    private double revenue;
    private MovieStatus status;
    private Set<Integer> genreIds;
    private Set<Integer> actorIds;
}
