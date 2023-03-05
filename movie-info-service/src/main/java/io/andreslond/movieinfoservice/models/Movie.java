package io.andreslond.movieinfoservice.models;

public class Movie {

    private String movieId;
    private String name;
    private String director;

    public Movie(String movieId, String name, String director) {
        this.movieId = movieId;
        this.name = name;
        this.director = director;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
