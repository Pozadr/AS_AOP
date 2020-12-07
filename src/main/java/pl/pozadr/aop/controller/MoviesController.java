package pl.pozadr.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pozadr.aop.dto.MovieDTO;
import pl.pozadr.aop.model.Movie;
import pl.pozadr.aop.service.movie.MovieService;
import pl.pozadr.aop.service.movie.MoviesServiceImpl;
import pl.pozadr.aop.aspect.email.SendEmail;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MovieService moviesService;


    @Autowired
    public MoviesController(MoviesServiceImpl moviesService) {
        this.moviesService = moviesService;
    }


    @GetMapping("/all-movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = moviesService.getMoviesList();
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/add-movie")
    @SendEmail
    public ResponseEntity<MovieDTO> postMovie(@Validated @RequestBody MovieDTO newMovie) {
        if (moviesService.postMovie(newMovie)) {
            return ResponseEntity.ok(newMovie);
        }
        return ResponseEntity.badRequest().build();
    }

}
