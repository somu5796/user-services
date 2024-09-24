package com.microservices.user_services.manager.impl;

import com.microservices.user_services.dto.UserRequest;
import com.microservices.user_services.dto.UserResponse;
import com.microservices.user_services.manager.UserServiceManager;
import com.microservices.user_services.model.User;
import com.microservices.user_services.repositories.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceManagerImpl implements UserServiceManager {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapEntityToDto).toList();
    }

    @Override
    public String addUser(UserRequest userRequest) {
        User user = userRepository.save(mapDtoToEntity(userRequest));
        return user!=null ? user.getId().toString(): null;
    }

    private User mapDtoToEntity(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getUserName())
                .address(userRequest.getAddress())
                .build();
    }

    private UserResponse mapEntityToDto(User user) {
        return UserResponse.builder()
                .userId(user.getId())
                .userName(user.getName())
                .address(user.getAddress())
                .build();
    }
}
