package com.movie.repository;

import com.movie.exception.DuplicateMovieException;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.MovieItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private final List<MovieItem> movies = new ArrayList<>();

    // 1️⃣ Save single movie
    public MovieItem save(MovieItem movie) {

        // Null safety check
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null");
        }

        if (movie.getId() == null) {
            throw new IllegalArgumentException("Movie ID cannot be null");
        }

        // Duplicate ID check (null-safe)
        boolean exists = movies.stream()
                .anyMatch(existingMovie ->
                        existingMovie.getId() != null &&
                                existingMovie.getId().equals(movie.getId())
                );

        if (exists) {
            throw new DuplicateMovieException(movie.getId());
        }

        movies.add(movie);
        return movie;
    }

    // 2️⃣ Save movies in bulk
    public List<MovieItem> saveAll(List<MovieItem> movieList) {

        if (movieList == null || movieList.isEmpty()) {
            throw new IllegalArgumentException("Movie list cannot be empty");
        }

        for (MovieItem movie : movieList) {
            save(movie); // reuse validation + duplicate logic
        }

        return movieList;
    }

    // 3️⃣ Get all movies
    public List<MovieItem> findAll() {
        return movies;
    }

    // 4️⃣ Get movie by id
    public MovieItem findById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Movie ID cannot be null");
        }

        return movies.stream()
                .filter(movie ->
                        movie.getId() != null &&
                                movie.getId().equals(id)
                )
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException(id));
    }
}
