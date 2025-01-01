package com.capstone.moviemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping(value = {"/home", "/"})
    public String Home()
    {
        return "Welcome to Jishan's Movie Management system!";
    }
}
