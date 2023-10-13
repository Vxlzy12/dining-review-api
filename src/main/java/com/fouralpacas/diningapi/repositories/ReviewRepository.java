package com.fouralpacas.diningapi.repositories;

import com.fouralpacas.diningapi.model.Review;
import com.fouralpacas.diningapi.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Review findByReviewStatus(ReviewStatus reviewStatus);
    List<Review> findByRestaurantIdAndReviewStatus(Long id, ReviewStatus reviewStatus);

}
