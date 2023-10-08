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

    //GET Mappings: Get by ID and get by zipCode (meeting some conditions)
    @GetMapping("/{id}")
    public Restaurant getRestaurants(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            return restaurant;
        } else {
            return null;
        }
    }

    //POST Mapping: Validate if restaurant already exists and then add the new restaurant
    @PostMapping("/")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurantToAdd) {
        Iterable<Restaurant> restaurantList = this.restaurantRepository.findAll();
        Long tempId = restaurantToAdd.getId();
        String tempName = restaurantToAdd.getName();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getId() == tempId || restaurant.getName() == tempName) {
                return null;
            }
        }
        this.restaurantRepository.save(restaurantToAdd);
        return restaurantToAdd;
    }





}

