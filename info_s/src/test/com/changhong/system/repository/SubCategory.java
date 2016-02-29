package com.changhong.system.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-24
 * Time: 上午10:07
 */
public class SubCategory {

    private int id;

    private String name;

    private String description;

    private List<Movie> movies = new ArrayList<Movie>();

    public SubCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
