package io.andreslond.moviecatalogservice.models;

import java.util.List;

public class RatingsData {

    private String userName;

    private List<Rating> ratings;

    public RatingsData() {
    }

    public RatingsData(String userName, List<Rating> ratings) {
        this.userName = userName;
        this.ratings = ratings;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}