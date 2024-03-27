package com.example.ooad.service;


import com.example.ooad.entity.Movie;
import com.example.ooad.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addRating(Long movieId, double rating) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            double currentRating = movie.getAverageRating();
            int numRatings = movie.getNumRatings();
            double newAverageRating = ((currentRating * numRatings) + rating) / (numRatings + 1);
            movie.setAverageRating(newAverageRating);
            movie.setNumRatings(numRatings + 1);
            movieRepository.save(movie);
        } else {
            // Handle movie not found
        }
    }

    public void addReview(Long movieId, String review) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            List<String> reviews = movie.getReviews();
            reviews.add(review);
            movie.setReviews(reviews);
            movieRepository.save(movie);
        } else {
            // Handle movie not found
        }
    }

    // Other methods for CRUD operations
}
