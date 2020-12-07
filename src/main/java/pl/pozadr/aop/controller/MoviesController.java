package pl.pozadr.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pozadr.aop.dto.MovieDTO;
import pl.pozadr.aop.model.Movie;
import pl.pozadr.aop.service.MoviesServiceImpl;
import pl.pozadr.aop.aspect.SendEmail;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesServiceImpl moviesServiceImpl;


    @Autowired
    public MoviesController(MoviesServiceImpl moviesServiceImpl) {
        this.moviesServiceImpl = moviesServiceImpl;
    }


    @GetMapping("/all-movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = moviesServiceImpl.getMoviesList();
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add-movie")
    @SendEmail
    public ResponseEntity<MovieDTO> addMovie(@Validated @RequestBody MovieDTO newMovie) {
        if (moviesServiceImpl.postMovie(newMovie)) {
            return ResponseEntity.ok(newMovie);
        }
        return ResponseEntity.badRequest().build();
    }

}
