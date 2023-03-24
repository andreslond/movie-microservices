package io.andreslond.movieinfoservice.models;

public class MovieSummary {

    private Integer id;
    private String adult;
    private Double budget;
    private String title;
    private String overview;
    private Double vote_average;

    public MovieSummary() {
    }

    public MovieSummary(Integer id, String adult, Double budget, String title, String overview, Double vote_average) {
        this.id = id;
        this.adult = adult;
        this.budget = budget;
        this.title = title;
        this.overview = overview;
        this.vote_average = vote_average;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }
}
