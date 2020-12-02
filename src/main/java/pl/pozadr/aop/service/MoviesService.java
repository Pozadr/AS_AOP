package pl.pozadr.aop.service;

import org.springframework.stereotype.Service;
import pl.pozadr.aop.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    private List<Movie> movies;

    public MoviesService() {
        movies = new ArrayList<>();
        movies.add(new Movie(1L, "Fight Club", "David Fincher", 1999));
        movies.add(new Movie(2L, "The Fifth Element", "Luc Besson", 1997));
        movies.add(new Movie(3L, "Braveheart", "Mel Gibson", 1995));
        movies.add(new Movie(4L, "Pulp Fiction", "Quentin Tarantino", 1994));
        movies.add(new Movie(5L, "The Matrix", "Lilly Wachowski / Lana Wachowski ", 1999));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public boolean addMovie(Movie newMovie) {
        movies.add(newMovie);
        return true;
    }

    public boolean isIdUnique(Movie movie) {
        Optional<Movie> sameIdMovie = movies.stream()
                .filter(mov -> mov.getId().equals(movie.getId()))
                .findFirst();
        return sameIdMovie.isEmpty();
    }
}
