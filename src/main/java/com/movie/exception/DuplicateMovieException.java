package com.movie.exception;

public class DuplicateMovieException extends RuntimeException {

    public DuplicateMovieException(Long id) {
        super("Movie already exists with id: " + id);
    }
}
