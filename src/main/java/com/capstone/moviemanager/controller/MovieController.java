package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.model.Movie;
import com.capstone.moviemanager.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    // HOME
    @GetMapping(value = {"/home", "/"})
    public String Home()
    {
        return "Welcome to Jishan's Movie Management system!";
    }

    // GET ALL
    @GetMapping("/movies")
    public List<Movie> getAllMovies()
    {
        return movieService.getAllMovies();
    }

    // GET ONE BY ID
    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    // CREATE
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    // UPDATE
    @PutMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    // DELETE
    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "Deleted movie with id: " + id;
    }
}
