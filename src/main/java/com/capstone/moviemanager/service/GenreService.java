package com.capstone.moviemanager.service;

import com.capstone.moviemanager.dto.GenreDto;
import com.capstone.moviemanager.model.Genre;
import com.capstone.moviemanager.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDto> getAllGenres() {
        return toDto(genreRepository.findAll());
    }

    public GenreDto getGenreById(int id) {
        return toDto(genreRepository.findById(id).orElse(null));
    }

    public GenreDto creatGenre(GenreDto genreDto) {
        Genre genre = toEntity(genreDto);
        genreRepository.save(genre);
        return toDto(genreRepository.findById(genre.getId()).orElse(null));
    }

    public GenreDto updateGenre(GenreDto genreDto) {
        Genre genre = toEntity(genreDto);
        genreRepository.save(genre);
        return toDto(genreRepository.findById(genre.getId()).orElse(null));
    }

    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }

    // ===================================================================

    public List<Genre> toEntity(List<GenreDto> genreDtos) {
        return genreDtos.stream()
                .map(genreDto -> toEntity(genreDto))
                .toList();
    }

    public Genre toEntity(GenreDto genreDto) {
        Genre genre = new Genre();

        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName());

        return genre;
    }

    public List<GenreDto> toDto(List<Genre> genres) {
        return genres.stream()
                .map(genre -> toDto(genre))
                .toList();
    }

    public GenreDto toDto(Genre genre) {
        GenreDto genreDto = new GenreDto();

        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());

        return genreDto;
    }
}
