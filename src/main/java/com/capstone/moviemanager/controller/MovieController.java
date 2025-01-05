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

    @GetMapping(value = {"/home", "/"})
    public String Home()
    {
        return "Welcome to Jishan's Movie Management system!";
    }

    @GetMapping("/movies")
    public List<MovieDto> getAllMovies()
    {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public MovieDto getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/movie")
    public MovieDto createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @PostMapping("/movies")
    public List<MovieDto> createMovies(@RequestBody  List<MovieDto> movieDtos) {
        return movieService.createMovies(movieDtos);
    }

    @PutMapping("/movie")
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        return movieService.updateMovie(movieDto);
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "Deleted movie with id: " + id;
    }
}
