package org.example.service;

import lombok.Data;
import org.example.pojo.City;
import org.example.pojo.Movie;
import org.example.pojo.Show;
import org.example.pojo.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TheatreService {
    private Map<City, List<Theatre>> theatreCityMap;
    private List<Theatre> allTheatres;

    public Map<Theatre, List<Show>> getTheatreShowsMap(City city, Movie movie) {
        Map<Theatre, List<Show>> theatreShowsMap = new HashMap<>();
        theatreCityMap.getOrDefault(city, new ArrayList<>())
                .forEach(theatre -> {
                    theatre.getShows()
                            .stream()
                            .filter(show -> show.getMovie().getMovieId() == movie.getMovieId())
                            .forEach(show -> theatreShowsMap.put(theatre, theatreShowsMap.getOrDefault(theatre, new ArrayList<>())));
                });
        return theatreShowsMap;
    }
}
