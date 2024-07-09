package org.example;

import org.example.enums.SeatCategory;
import org.example.pojo.*;
import org.example.service.MovieService;
import org.example.service.TheatreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private final MovieService movieService;
    private TheatreService theatreService;

    public Main() {
        movieService = new MovieService();
        theatreService = new TheatreService();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();

        // user 1...
        main.createBooking(new City(1, "Bangalore"), 1);
    }

    private void createBooking(City city, int movieId) {
        List<Movie> cityMovies = movieService.getCityMovies(city);
        Movie interestedMovie = cityMovies
                .stream()
                .filter(
                        movie -> movie.getMovieId() == movieId
                )
                .findFirst()
                .orElse(null);
        Map<Theatre, List<Show>> theatreListMap = theatreService.getTheatreShowsMap(city, interestedMovie);
        Show interestedShow = theatreListMap.values()
                .stream()
                .flatMap(List::stream)
                .findFirst()
                .orElse(null);
        // start booking check if seat is not booked...
        // do payment
        // save to booked seats
    }

    private void init() {
        createMovies();
        createTheatres();
    }

    private void createTheatres() {
        Movie movie1 = movieService.getMovieById(1);
        Movie movie2 = movieService.getMovieById(2);

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setCity(new City(1, "Bangalore"));
        inoxTheatre.setScreens(createScreens());
        inoxTheatre.setShows(createShows(movie1, movie2, inoxTheatre));
    }

    private List<Show> createShows(Movie movie1, Movie movie2, Theatre theatre) {
        List<Show> shows = new ArrayList<>();
        Show show1 = new Show(1, movie1, theatre.getScreens().get(0), 1, null);
        shows.add(show1);
        Show show2 = new Show(2, movie2, theatre.getScreens().get(1), 2, null);
        shows.add(show2);
        return shows;
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen(1, createSeats());
        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        Seat goldSeat = new Seat(1, 1, SeatCategory.GOLD, 1);
        seats.add(goldSeat);
        Seat silverSeat = new Seat(2, 2, SeatCategory.SILVER, 2);
        seats.add(silverSeat);
        Seat platinumSeat = new Seat(3, 3, SeatCategory.PLATINUM, 3);
        seats.add(platinumSeat);
        return seats;
    }

    private void createMovies() {
        Movie movie1 = new Movie(1, "The Shawshank Redemption", 142, "comedy", "English");
        Movie movie2 = new Movie(2, "The Godfather", 175, "crime", "English");
        movieService.addMovie(movie1, new City(1, "Bangalore"));
        movieService.addMovie(movie2, new City(2, "Delhi"));
    }
}