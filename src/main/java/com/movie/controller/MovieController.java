package com.movie.controller;

import com.movie.model.MovieItem;
import com.movie.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    // 1️⃣ Add single movie
    @PostMapping
    public ResponseEntity<MovieItem> addMovie(
            @Valid @RequestBody MovieItem movie) {

        return ResponseEntity.ok(repository.save(movie));
    }

    // 2️⃣ Add movies in bulk
    @PostMapping("/bulk")
    public ResponseEntity<List<MovieItem>> addMoviesBulk(
            @Valid @RequestBody List<MovieItem> movies) {

        return ResponseEntity.ok(repository.saveAll(movies));
    }

    // 3️⃣ Get all movies
    @GetMapping
    public ResponseEntity<List<MovieItem>> getAllMovies() {
        return ResponseEntity.ok(repository.findAll());
    }

    // 4️⃣ Get movie by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
