package io.andreslond.ratingsdataservice.resources;

import io.andreslond.ratingsdataservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    @RequestMapping("users/{userId}")
    public List<Rating> getRatedMoviesByUserId(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("Movie01", 5),
                new Rating("Movie02", 1)
        );
        return ratings;
    }
}
