package com.capstone.moviemanager.repository;

import com.capstone.moviemanager.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
