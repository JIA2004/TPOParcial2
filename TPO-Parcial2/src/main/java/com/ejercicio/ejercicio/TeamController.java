package com.ejercicio.ejercicio;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.ejercicio.model.TeamEntity;
import com.ejercicio.ejercicio.repository.TeamRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/teams") // Cambiado a reflejar equipos
public class TeamController {
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // Crear o actualizar un equipo
    @PutMapping
    Mono<TeamEntity> createOrUpdateTeam(@RequestBody TeamEntity newTeam) {
        return teamRepository.save(newTeam);
    }

    // Obtener todos los equipos
    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<TeamEntity> getTeams() {
        return teamRepository.findAll();
    }
}
