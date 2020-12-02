package pl.pozadr.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pozadr.aop.model.Movie;
import pl.pozadr.aop.service.MoviesService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/all-movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = moviesService.getMovies();
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add-movie")
    public ResponseEntity<Movie> addMovie(@Validated @RequestBody Movie newMovie) {
        if (!moviesService.isIdUnique(newMovie)) {
            return new ResponseEntity("{\n\t\"id\": \"not unique.\"\n}", HttpStatus.BAD_REQUEST);
        }
        if (moviesService.addMovie(newMovie)) {
            return ResponseEntity.ok(newMovie);
        }
        return ResponseEntity.badRequest().build();
    }

}
