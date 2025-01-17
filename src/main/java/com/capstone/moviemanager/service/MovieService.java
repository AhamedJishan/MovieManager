package com.capstone.moviemanager.service;

import com.capstone.moviemanager.dto.MovieDto;
import com.capstone.moviemanager.model.Actor;
import com.capstone.moviemanager.model.Genre;
import com.capstone.moviemanager.model.Movie;
import com.capstone.moviemanager.repository.ActorRepository;
import com.capstone.moviemanager.repository.GenreRepository;
import com.capstone.moviemanager.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ActorRepository actorRepository;


    public List<MovieDto> getAllMovies() {
        return toDto(movieRepository.findAll());
    }

    public MovieDto getMovieById(int id) {
        return toDto(movieRepository.findById(id).orElse(null));
    }

    public List<MovieDto> createMovies(List<MovieDto> movieDtos) {
        return movieDtos.stream()
                .map(movieDto -> createMovie(movieDto))
                .toList();
    }

    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = toEntity(movieDto);
        movieRepository.save(movie);
        return  toDto(movieRepository.findById(movie.getId()).orElse(null));
    }

    public MovieDto updateMovie(MovieDto movieDto) {
        Movie movie = toEntity(movieDto);
        movieRepository.save(movie);
        return  toDto(movieRepository.findById(movie.getId()).orElse(null));
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }


    // ================================================================================
    // NOTE: ========================= UTILITY FUNCTIONS ==============================
    // ================================================================================

    public List<Movie> toEntity(List<MovieDto> movieDtos) {
        return movieDtos.stream()
                .map(movieDto -> toEntity(movieDto))
                .toList();
    }

    public Movie toEntity (MovieDto movieDto) {
        Movie movie = new Movie();

        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setTagline(movieDto.getTagline());
        movie.setOverview(movieDto.getOverview());
        movie.setRevenue(movieDto.getRevenue());
        movie.setStatus(movieDto.getStatus());

        Set<Genre> genres = new HashSet<>(genreRepository.findAllById(movieDto.getGenreIds()));
        movie.setGenres(genres);

        Set<Actor> actors = new HashSet<>(actorRepository.findAllById(movieDto.getActorIds()));
        movie.setActors(actors);

        return movie;
    }

    public List<MovieDto> toDto(List<Movie> movies) {
        return movies.stream()
                .map(movie -> toDto(movie))
                .toList();
    }

    public MovieDto toDto(Movie movie) {
        MovieDto movieDto = new MovieDto();

        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setTagline(movie.getTagline());
        movieDto.setOverview(movie.getOverview());
        movieDto.setRevenue(movie.getRevenue());
        movieDto.setStatus(movie.getStatus());

        Set<Integer> genres = movie.getGenres().stream().map(genre -> genre.getId()).collect(Collectors.toSet());
        movieDto.setGenreIds(genres);

        Set<Integer> actors = movie.getActors().stream().map(actor -> actor.getId()).collect(Collectors.toSet());
        movieDto.setActorIds(actors);

        return movieDto;
    }
}
