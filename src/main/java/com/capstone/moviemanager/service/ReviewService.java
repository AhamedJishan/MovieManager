package com.capstone.moviemanager.service;

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

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(@PathVariable int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(@PathVariable int id) {
        reviewRepository.deleteById(id);
    }
}
