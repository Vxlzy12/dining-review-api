package com.fouralpacas.diningapi.controllers;

import com.fouralpacas.diningapi.model.Restaurant;
import com.fouralpacas.diningapi.repositories.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public Restaurant getById(@RequestParam Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if(!restaurantOptional.isPresent()) {
            return null;
        }
        return restaurantOptional.get();
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurantToAdd) {
        this.restaurantRepository.save(restaurantToAdd);
        return restaurantToAdd;
    }
}

