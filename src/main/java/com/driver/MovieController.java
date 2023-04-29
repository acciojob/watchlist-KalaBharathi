package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }
    @PutMapping("add-movie-director-Pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity("Added Successfully", HttpStatus.CREATED);
    }
    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@RequestParam("name") String movieName){
        Movie movie=movieService.getMovieByName(movieName);
        return new ResponseEntity(movie, HttpStatus.OK);
    }
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String directorName){
        Director director=movieService.getDirectorByName(directorName);
        return new ResponseEntity(director, HttpStatus.OK);
    }
    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> movieList=movieService.getMoviesByDirectorName(director);
        return new ResponseEntity(movieList, HttpStatus.OK);
    }
    @GetMapping("get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> movies=movieService.findAllMovies();
        return new ResponseEntity(movies, HttpStatus.OK);
    }
    @DeleteMapping("delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirectorByName(director);
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }
    @DeleteMapping("delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }
}
