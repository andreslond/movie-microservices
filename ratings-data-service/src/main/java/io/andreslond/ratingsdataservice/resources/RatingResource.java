package io.andreslond.ratingsdataservice.resources;

import io.andreslond.ratingsdataservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
}
