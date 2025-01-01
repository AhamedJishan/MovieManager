package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.model.Movie;
import com.capstone.moviemanager.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = {"/home", "/"})
    public String Home()
    {
        return "Welcome to Jishan's Movie Management system!";
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies()
    {
        return movieService.getAllMovies();
    }


    // TODO: CREATE
    // TODO: UPDATE
    // TODO: DELETE
}
