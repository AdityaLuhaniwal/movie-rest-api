package com.movie.repository;

import com.movie.model.MovieItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    private final List<MovieItem> movies = new ArrayList<>();

    // Save single movie
    public MovieItem save(MovieItem movie) {
        movies.add(movie);
        return movie;
    }

    // Save multiple movies (bulk)
    public List<MovieItem> saveAll(List<MovieItem> movieList) {
        movies.addAll(movieList);
        return movieList;
    }

    // Get all movies
    public List<MovieItem> findAll() {
        return movies;
    }

    // Get movie by id
    public Optional<MovieItem> findById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }
}
