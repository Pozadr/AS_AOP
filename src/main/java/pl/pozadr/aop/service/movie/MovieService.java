package pl.pozadr.aop.service.movie;

import pl.pozadr.aop.dto.MovieDTO;
import pl.pozadr.aop.model.Movie;

import java.util.List;

public interface MovieService {
    boolean postMovie(MovieDTO newMovie);

    List<Movie> getMoviesList();
}
