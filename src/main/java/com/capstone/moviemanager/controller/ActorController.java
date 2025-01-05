package com.capstone.moviemanager.controller;

import com.capstone.moviemanager.dto.ActorDto;
import com.capstone.moviemanager.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actors")
    public List<ActorDto> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/actor/{id}")
    public ActorDto getActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }

    @PostMapping("/actor")
    public ActorDto createActor(@RequestBody ActorDto actorDto) {
        return actorService.createActor(actorDto);
    }

    @PostMapping("/actors")
    public List<ActorDto> createActors(@RequestBody List<ActorDto> actorDtos) {
        return actorService.createActos(actorDtos);
    }

    @PutMapping("/actor")
    public ActorDto updateActor(@RequestBody ActorDto actorDto) {
        return actorService.updateActor(actorDto);
    }

    @DeleteMapping("/actor/{int}")
    public String deleteActor(@PathVariable int id) {
        actorService.deleteActor(id);
        return "Deleted Actor with id: " + id;
    }
}
