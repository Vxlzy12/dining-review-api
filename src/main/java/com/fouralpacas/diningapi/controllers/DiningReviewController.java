package com.fouralpacas.diningapi.controllers;

import com.fouralpacas.diningapi.model.Restaurant;
import com.fouralpacas.diningapi.model.Review;
import com.fouralpacas.diningapi.model.ReviewStatus;
import com.fouralpacas.diningapi.repositories.RestaurantRepository;
import com.fouralpacas.diningapi.repositories.ReviewRepository;
import com.fouralpacas.diningapi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class DiningReviewController {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    public DiningReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    /* @GetMapping
    public String helloWorld() {
        return "Hello World";
    } */

    //Find accepted restaurants by ID
    @GetMapping("/{id}")
    public List<Review> getByRestaurant(@PathVariable Long id) {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(id);
        if(!optionalRestaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return this.reviewRepository.findByRestaurantIdAndReviewStatus(id, ReviewStatus.ACCEPTED);
    }

    //Add new review and set its status to PENDING
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Review postReview(@RequestBody Review review) {
        if(!userRepository.existsByDisplayName(review.getDisplayName())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        review.setReviewStatus(ReviewStatus.PENDING);
        this.reviewRepository.save(review);
        return review;
    }

    //Admin endpoint to get pending reviews
    @GetMapping("/admin")
    public Review getPendingReviews() {
        return this.reviewRepository.findByReviewStatus(ReviewStatus.PENDING);
    }

    //Admin endpoint to change a review's status either to ACCEPTED or REJECTED
    @PutMapping("/admin/{id}")
    public Review setReviewStatus(@PathVariable Long id, @RequestParam Boolean accepted) {
        Optional<Review> optionalReview = this.reviewRepository.findById(id);
        if (!optionalReview.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Review review = optionalReview.get();
        if (accepted) {
            review.setReviewStatus(ReviewStatus.ACCEPTED);
        } else {
            review.setReviewStatus(ReviewStatus.REJECTED);
        }
        this.reviewRepository.save(review);
        return review;

    }

}
