package com.movie.model;

import jakarta.validation.constraints.*;

public class MovieItem {

    @NotNull(message = "Id is required")
    @Positive(message = "Id must be a positive number")
    private Long id;

    @NotBlank(message = "Movie name is required")
    @Size(min = 2, max = 100, message = "Movie name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters")
    private String description;

    @Size(max = 50, message = "Genre must not exceed 50 characters")
    private String genre;

    public MovieItem() {}

    public MovieItem(Long id, String name, String description, String genre) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
    }

    // ✅ getters & setters (IMPORTANT)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
