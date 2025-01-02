package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.model.Genre;
import com.capstone.moviemanager.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/genre/{id}")
    public Genre getGenreById(@PathVariable int id) {
        return genreService.getGenreById(id);
    }

    @PostMapping("/genre")
    public Genre creatGenre(@RequestBody Genre genre) {
        return genreService.creatGenre(genre);
    }

    @PutMapping("/genre")
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreService.updateGenre(genre);
    }

    @DeleteMapping("/genre/{id}")
    public String deleteGenre(@PathVariable int id) {
        genreService.deleteGenre(id);
        return "Deleted Genre with id:" + id;
    }
}
