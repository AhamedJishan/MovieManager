package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.dto.GenreDto;
import com.capstone.moviemanager.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public List<GenreDto> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/genre/{id}")
    public GenreDto getGenreById(@PathVariable int id) {
        return genreService.getGenreById(id);
    }

    @PostMapping("/genre")
    public GenreDto createGenre(@RequestBody GenreDto genreDto) {
        return genreService.createGenre(genreDto);
    }

    @PostMapping("/genres")
    public List<GenreDto> creatGenres(@RequestBody List<GenreDto> genreDtos) {
        return genreService.createGenres(genreDtos);
    }

    @PutMapping("/genre")
    public GenreDto updateGenre(@RequestBody GenreDto genreDto) {
        return genreService.updateGenre(genreDto);
    }

    @DeleteMapping("/genre/{id}")
    public String deleteGenre(@PathVariable int id) {
        genreService.deleteGenre(id);
        return "Deleted Genre with id:" + id;
    }
}
