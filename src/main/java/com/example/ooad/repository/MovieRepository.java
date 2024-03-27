package com.example.ooad.repository;



import com.example.ooad.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // You can add custom query methods here if needed
}
