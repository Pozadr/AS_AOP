package pl.pozadr.aop.repository;

import pl.pozadr.aop.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMoviesList();

    boolean addMovie(Movie newMovie);
}
