package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class MovieRepository {
    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap =new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        List<String> currentMoviesOfDirector=new ArrayList<>();
        if(directorMovieMap.containsKey(directorName)){
            currentMoviesOfDirector=directorMovieMap.get(directorName);
        }
        currentMoviesOfDirector.add(movieName);
            directorMovieMap.put(directorName,currentMoviesOfDirector);
        }

    public Director findDirector(String directorName) {
        return directorMap.get(directorName);
    }

    public Movie findMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return directorMovieMap.get(director);
    }

    public List<String> findAllMovies() {
        /*Set<String> keySet=movieMap.keySet();
        List<String> movies=new ArrayList<>();
        return movies.addAll(keySet);*/
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorByName(String director) {
        directorMap.remove(director);
        for(String movie:directorMovieMap.get(director)) {
            movieMap.remove(movie);
        }
        directorMovieMap.remove(director);
    }

    public void deleteAllDirectors() {
        for(String key:directorMap.keySet()){
            directorMap.remove(key);
            for(String movie:directorMovieMap.get(key)){
                movieMap.remove(movie);
            }
            directorMovieMap.remove(key);
    }
}
}
