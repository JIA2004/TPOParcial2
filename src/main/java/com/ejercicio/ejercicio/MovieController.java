package com.ejercicio.ejercicio;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.ejercicio.model.MovieEntity;
import com.ejercicio.ejercicio.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private final MovieRepository movieRepository;
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

    @PutMapping
    Mono<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
	    return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEntity> getMovies() {
	    return movieRepository.findAll();
    }

}
