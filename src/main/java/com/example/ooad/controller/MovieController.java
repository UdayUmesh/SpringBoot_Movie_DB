// package com.example.ooad.controller;

// import com.example.ooad.entity.Movie;
// import com.example.ooad.service.MovieService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.util.List;

// @Controller
// public class MovieController {

//     @Autowired
//     private MovieService movieService;

//     @GetMapping("/")
//     public String showMovieList(Model model) {
//         List<Movie> movies = movieService.getAllMovies();
//         model.addAttribute("movies", movies);
//         return "movieList"; // Thymeleaf template name
//     }

//     @PostMapping("/addRating")
//     public String addRating(@RequestParam Long movieId, @RequestParam double rating) {
//         movieService.addRating(movieId, rating);
//         return "redirect:/";
//     }

//     @PostMapping("/addReview")
//     public String addReview(@RequestParam Long movieId, @RequestParam String review) {
//         movieService.addReview(movieId, review);
//         return "redirect:/";
//     }
// }


package com.example.ooad.controller;

import com.example.ooad.entity.Movie;
import com.example.ooad.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String showMovieList(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        for (Movie movie : movies) {
            System.out.println("Movie name: " + movie.getName());
        }
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @PostMapping("/addRating")
    public String addRating(@RequestParam Long movieId, @RequestParam double rating) {
        movieService.addRating(movieId, rating);
        return "redirect:/";
    }

    @PostMapping("/addReview")
    public String addReview(@RequestParam Long movieId, @RequestParam String review) {
        movieService.addReview(movieId, review);
        return "redirect:/";
    }
}