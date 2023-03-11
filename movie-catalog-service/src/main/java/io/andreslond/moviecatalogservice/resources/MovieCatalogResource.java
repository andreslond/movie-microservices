package io.andreslond.moviecatalogservice.resources;

import io.andreslond.moviecatalogservice.models.CatalogItem;
import io.andreslond.moviecatalogservice.models.Movie;
import io.andreslond.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        RestTemplate restTemplate = new RestTemplate();


        // get all rated movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("567", 1)
        );

        // For each movie Id, call movie info service and get movie details.
        return ratings.stream().map(rating -> {

            Movie ratedMovie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId() , Movie.class);

            return new CatalogItem(ratedMovie.getName(), ratedMovie.getDirector(), rating.getRating());
        }).collect(Collectors.toList());

        // Put them all together as a response.

    }
}
