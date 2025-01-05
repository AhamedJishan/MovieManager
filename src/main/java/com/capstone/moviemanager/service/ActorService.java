package com.capstone.moviemanager.service;

import com.capstone.moviemanager.dto.ActorDto;
import com.capstone.moviemanager.model.Actor;
import com.capstone.moviemanager.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<ActorDto> getAllActors() {
        return toDto(actorRepository.findAll());
    }

    public ActorDto getActorById(int id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        return toDto(actor);
    }

    public List<ActorDto> createActos(List<ActorDto> actorDtos) {
        return actorDtos.stream()
                .map(actorDto -> createActor(actorDto))
                .toList();
    }

    public ActorDto createActor(ActorDto actorDto) {
        Actor actor = toEntity(actorDto);
        actorRepository.save(actor);
        return toDto(actorRepository.findById(actor.getId()).orElse(null));
    }

    public ActorDto updateActor(ActorDto actorDto) {
        Actor actor = toEntity(actorDto);
        actorRepository.save(actor);
        return toDto(actorRepository.findById(actor.getId()).orElse(null));
    }

    public void deleteActor(int id) {
        actorRepository.deleteById(id);
    }


    // ================================================================================
    // NOTE: ========================= UTILITY FUNCTIONS ==============================
    // ================================================================================

    public List<Actor> toEntity(List<ActorDto> actorDtos) {
        return actorDtos.stream()
                .map(actorDto -> toEntity(actorDto))
                .toList();
    }

    public Actor toEntity(ActorDto actorDto) {
        Actor actor = new Actor();

        actor.setId(actorDto.getId());
        actor.setName(actorDto.getName());
        actor.setGender(actorDto.getGender());
        actor.setPopularity(actorDto.getPopularity());

        return actor;
    }

    public List<ActorDto> toDto(List<Actor> actors) {
        return actors.stream()
                .map(actor -> toDto(actor))
                .toList();
    }

    public ActorDto toDto(Actor actor) {
        ActorDto actorDto = new ActorDto();

        actorDto.setId(actor.getId());
        actorDto.setName(actor.getName());
        actorDto.setGender(actor.getGender());
        actorDto.setPopularity(actor.getPopularity());

        return actorDto;
    }
}
