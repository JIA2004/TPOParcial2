package com.ejercicio.ejercicio.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import com.ejercicio.ejercicio.model.TeamEntity;
import reactor.core.publisher.Mono;

public interface TeamRepository extends ReactiveNeo4jRepository<TeamEntity, String> {
    Mono<TeamEntity> findOneByName(String name); // Cambiado "title" por "name"
}
