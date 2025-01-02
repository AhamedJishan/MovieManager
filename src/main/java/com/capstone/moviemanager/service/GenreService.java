package com.capstone.moviemanager.service;

import com.capstone.moviemanager.model.Genre;
import com.capstone.moviemanager.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(int id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre creatGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
