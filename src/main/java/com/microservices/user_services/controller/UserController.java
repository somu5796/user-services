package com.microservices.user_services.controller;

import com.microservices.user_services.dto.UserRequest;
import com.microservices.user_services.dto.UserResponse;
import com.microservices.user_services.manager.UserServiceManager;
import com.microservices.user_services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceManager userServiceManager;

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userServiceManager.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody UserRequest userRequest){
        String response = userServiceManager.addUser(userRequest);
        return response!=null? "User Id : "+response+ " added successfully": null;
    }

}
