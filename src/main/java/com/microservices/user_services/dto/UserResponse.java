package com.microservices.user_services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private Long userId;
    private String userName;
    private String address;
}
