package com.capstone.moviemanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDto {

    private int id;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private String content;
    private int movieId;
}
