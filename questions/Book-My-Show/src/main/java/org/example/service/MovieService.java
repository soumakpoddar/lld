package org.example.service;

import org.example.pojo.City;
import org.example.pojo.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {
    private final Map<City, List<Movie>> cityMovieMap;
    private final List<Movie> allMovies;

    public MovieService() {
        cityMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> cityMovies = cityMovieMap.getOrDefault(city, new ArrayList<>());
        cityMovies.add(movie);
        cityMovieMap.put(city, cityMovies);
    }

    public List<Movie> getCityMovies(City city) {
        return cityMovieMap.getOrDefault(city, new ArrayList<>());
    }

    public Movie getMovieById(int id) {
        return allMovies
                .stream()
                .filter(
                        movie -> movie.getMovieId() == id
                )
                .findFirst()
                .orElse(null);
    }
}
