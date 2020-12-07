package pl.pozadr.aop.repository;

import org.springframework.stereotype.Repository;
import pl.pozadr.aop.dto.MovieDTO;
import pl.pozadr.aop.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl {
    private List<Movie> movies;

    public MovieRepositoryImpl() {
        movies = new ArrayList<>();
        initializeRepository();
    }


    private void initializeRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie(1L, "Fight Club", "David Fincher", 1999));
        movies.add(new Movie(2L, "The Fifth Element", "Luc Besson", 1997));
        movies.add(new Movie(3L, "Braveheart", "Mel Gibson", 1995));
        movies.add(new Movie(4L, "Pulp Fiction", "Quentin Tarantino", 1994));
        movies.add(new Movie(5L, "The Matrix", "Lilly Wachowski / Lana Wachowski ", 1999));
    }


    public List<Movie> getMoviesList() {
        return movies;
    }


    public boolean addMovie(Movie newMovie) {
        return movies.add(newMovie);
    }

}
