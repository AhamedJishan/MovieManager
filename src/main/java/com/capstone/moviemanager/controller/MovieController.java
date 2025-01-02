package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.dto.MovieDto;
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
    public List<MovieDto> getAllMovies()
    {
        return movieService.getAllMovies();
    }

    // GET ONE BY ID
    @GetMapping("/movie/{id}")
    public MovieDto getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    // CREATE
    @PostMapping("/movie")
    public MovieDto createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    // UPDATE
    @PutMapping("/movie")
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        return movieService.updateMovie(movieDto);
    }

    // DELETE
    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "Deleted movie with id: " + id;
    }
}
