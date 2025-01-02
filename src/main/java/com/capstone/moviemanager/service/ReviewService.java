package com.capstone.moviemanager.service;

import com.capstone.moviemanager.dto.ReviewDto;
import com.capstone.moviemanager.model.Movie;
import com.capstone.moviemanager.model.Review;
import com.capstone.moviemanager.repository.MovieRepository;
import com.capstone.moviemanager.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;


    public List<ReviewDto> getAllReviews() {
        return toDto(reviewRepository.findAll());
    }

    public ReviewDto getReviewById(@PathVariable int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        return toDto(review);
    }

    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
        Review review = toEntity(reviewDto);
        reviewRepository.save(review);
        return toDto(reviewRepository.findById(review.getId()).orElse(null));
    }

    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto) {
        Review review = toEntity(reviewDto);
        reviewRepository.save(review);
        return toDto(reviewRepository.findById(review.getId()).orElse(null));
    }

    public void deleteReview(@PathVariable int id) {
        reviewRepository.deleteById(id);
    }

    // ==========================================================================

    public List<Review> toEntity(List<ReviewDto> reviewDtos) {
        return reviewDtos.stream()
                .map(reviewDto -> toEntity(reviewDto))
                .toList();
    }

    public Review toEntity(ReviewDto reviewDto) {
        Review review = new Review();

        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setAuthor(reviewDto.getAuthor());
        review.setContent(reviewDto.getContent());
        review.setCreatedAt(reviewDto.getCreatedAt());
        review.setUpdatedAt(reviewDto.getUpdatedAt());

        Movie movie = movieRepository.findById(reviewDto.getMovieId()).orElse(null);
        review.setMovie(movie);

        return review;
    }

    public List<ReviewDto> toDto(List<Review> reviews) {
        return reviews.stream()
                .map(review -> toDto(review))
                .toList();
    }

    public ReviewDto toDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setAuthor(review.getAuthor());
        reviewDto.setContent(review.getContent());
        reviewDto.setCreatedAt(review.getCreatedAt());
        reviewDto.setUpdatedAt(review.getUpdatedAt());
        reviewDto.setMovieId(review.getMovie().getId());

        return reviewDto;
    }
}
