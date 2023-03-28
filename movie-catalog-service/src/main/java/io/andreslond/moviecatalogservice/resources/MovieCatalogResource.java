package io.andreslond.moviecatalogservice.resources;

import com.netflix.discovery.DiscoveryClient;
import io.andreslond.moviecatalogservice.models.CatalogItem;
import io.andreslond.moviecatalogservice.models.Movie;
import io.andreslond.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webclientBuilder;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // get all rated movie IDs
        UserRating userRating = webclientBuilder.build()
                .get()
                .uri("http://RATINGS-DATA-SERVICE/ratingsdata/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();

        // For each movie Id, call movie info service and get movie details.
        return userRating.getRatings().stream().map(rating -> {

            //Movie ratedMovie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            Movie ratedMovie = webclientBuilder.build()
                    .get()
                    .uri("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(ratedMovie.getName(), ratedMovie.getOverview(), rating.getRating());
        }).collect(Collectors.toList());

        // Put them all together as a response.

    }
}
