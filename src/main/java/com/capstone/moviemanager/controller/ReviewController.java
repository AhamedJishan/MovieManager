package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.dto.ReviewDto;
import com.capstone.moviemanager.model.Review;
import com.capstone.moviemanager.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<ReviewDto> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/review/{id}")
    public ReviewDto getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping("/review")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(reviewDto);
    }

    @PutMapping("/review")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.updateReview(reviewDto);
    }

    @DeleteMapping("/review/{id}")
    public String deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
        return "Deleted Review with id: " + id;
    }
}
