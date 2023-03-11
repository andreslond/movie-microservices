package io.andreslond.movieinfoservice.resources;

import io.andreslond.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieInformation(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Movie Test Name", "Director name");
    }
}
