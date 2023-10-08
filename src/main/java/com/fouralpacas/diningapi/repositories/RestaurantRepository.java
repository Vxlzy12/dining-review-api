package com.fouralpacas.diningapi.repositories;

import com.fouralpacas.diningapi.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    Optional<Restaurant> findById(Long id);

}
