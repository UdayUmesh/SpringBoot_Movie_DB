package com.example.ooad.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String director;
    public int releaseYear;
    public double averageRating;
    public int numRatings;

    @ElementCollection
    private List<String> reviews;

    // Constructors, getters, and setters
    // Omitted for brevity
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getDirector(){
        return director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}

