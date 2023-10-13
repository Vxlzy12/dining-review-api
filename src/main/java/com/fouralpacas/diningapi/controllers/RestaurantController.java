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

    //Find restaurant by its unique ID
    @GetMapping
    public Restaurant getById(@RequestParam Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if(!restaurantOptional.isPresent()) {
            return null;
        }
        return restaurantOptional.get();
    }

    //Find restaurants by zip code and sorted by their score for a specific allergy, descending order
    @GetMapping("/{zipCode}")
    public List<Restaurant> getByZipCode(@PathVariable Integer zipCode, @RequestParam String allergy) {
        if (allergy.toLowerCase() == "peanut") {
            return this.restaurantRepository.findByZipCodeOrderByPeanutScoreDesc(zipCode);
        } else if (allergy.toLowerCase() == "egg") {
            return this.restaurantRepository.findByZipCodeOrderByEggScoreDesc(zipCode);
        } else if (allergy.toLowerCase() == "dairy") {
            return this.restaurantRepository.findByZipCodeOrderByDairyScoreDesc(zipCode);
        } else {
            return this.restaurantRepository.findByZipCode(zipCode);
        }
    }

    //Add restaurant
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurantToAdd) {
        if(this.restaurantRepository.existsByName(restaurantToAdd.getName()) && this.restaurantRepository.existsByZipCode(restaurantToAdd.getZipCode())) {
            return null;
        }
        this.restaurantRepository.save(restaurantToAdd);
        return restaurantToAdd;
    }
}

