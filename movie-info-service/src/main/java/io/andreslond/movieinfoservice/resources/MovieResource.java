package io.andreslond.movieinfoservice.resources;

import io.andreslond.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${movie.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInformation(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Movie Test Name", "Director name");
    }
}
