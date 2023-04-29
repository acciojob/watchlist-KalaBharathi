package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(Objects.nonNull(movieRepository.findDirector(directorName)) && Objects.nonNull(movieRepository.findMovie(movieName))){
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
}

    public Movie getMovieByName(String movieName) {
            return movieRepository.findMovie(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return movieRepository.findDirector(directorName);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String director) {
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
