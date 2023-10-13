package com.fouralpacas.diningapi.controllers;

import com.fouralpacas.diningapi.model.User;
import com.fouralpacas.diningapi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Get a user by its display name
    @GetMapping("/{displayName}")
    public User getUser(@PathVariable String displayName) {
        Optional<User> optionalUser = this.userRepository.findByDisplayName(displayName);
        //Check if display name exists
        if(!optionalUser.isPresent()) {
            return null;
        }
        return optionalUser.get();
    }

    //Add new user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User addUser(@RequestBody User user) {
        //Alternate way to check if a display name exists, and return error if user already exists
        if(this.userRepository.existsByDisplayName(user.getDisplayName())) {
            return null;
        }
        this.userRepository.save(user);
        return user;
    }

    //Update profile data for a display name
    @PutMapping("/{displayName}")
    public User updateUser(@PathVariable String displayName, @RequestBody User newUser) {
        //Check if user exists (display name can not be changed)
        Optional<User> optionalOldUser = this.userRepository.findByDisplayName(displayName);
        if(!optionalOldUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User oldUser = optionalOldUser.get();
        copyUserData(oldUser, newUser);
        this.userRepository.save(oldUser);
        return oldUser;
    }

    //Copy data from request body to the existing user
    private User copyUserData(User oldUser, User newUser) {
        oldUser.setCity(newUser.getCity());
        oldUser.setState(newUser.getState());
        oldUser.setPeanutAllergy(newUser.getPeanutAllergy());
        oldUser.setEggAllergy(newUser.getEggAllergy());
        oldUser.setDairyAllergy(newUser.getDairyAllergy());
        oldUser.setZipCode(newUser.getZipCode());
        return oldUser;
    }

}
