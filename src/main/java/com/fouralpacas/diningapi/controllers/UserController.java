package com.fouralpacas.diningapi.controllers;

import com.fouralpacas.diningapi.model.User;
import com.fouralpacas.diningapi.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
