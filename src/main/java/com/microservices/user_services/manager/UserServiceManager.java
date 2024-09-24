package com.microservices.user_services.manager;

import com.microservices.user_services.dto.UserRequest;
import com.microservices.user_services.dto.UserResponse;

import java.util.List;

public interface UserServiceManager {
    List<UserResponse> getAllUsers();
    String addUser(UserRequest userRequest);
}
