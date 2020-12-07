package pl.pozadr.aop.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pozadr.aop.dto.MovieDTO;
import pl.pozadr.aop.model.Movie;
import pl.pozadr.aop.repository.MovieRepositoryImpl;


import java.util.List;

@Service
public class MoviesServiceImpl implements MovieService{
    private final MovieRepositoryImpl movieRepository;

    @Autowired
    public MoviesServiceImpl(MovieRepositoryImpl repository) {
       movieRepository = repository;
    }

    @Override
    public boolean postMovie(MovieDTO newMovie) {

        Movie movieToAdd = mapMovieDTOtoMovie(newMovie);
        movieRepository.addMovie(movieToAdd);
        return true;
    }


    @Override
    public List<Movie> getMoviesList() {
        return movieRepository.getMoviesList();
    }


    private Movie mapMovieDTOtoMovie(MovieDTO movieDTO) {
        Long id = getNextId();
        String title = movieDTO.getTitle();
        String producer = movieDTO.getProducer();
        Integer yearOfProduction = Integer.parseInt(movieDTO.getYearOfProduction());
        return new Movie(id, title, producer, yearOfProduction);
    }


    private Long getNextId() {
        List<Movie> movies = movieRepository.getMoviesList();
        return (long) (movies.size() + 1);
    }
}
