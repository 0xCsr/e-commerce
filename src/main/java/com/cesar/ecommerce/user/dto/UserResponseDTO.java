package com.cesar.ecommerce.user.dto;

import java.util.UUID;

import com.cesar.ecommerce.user.User;

public record UserResponseDTO(
    UUID id,
    String email,
    String firstName
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getFirstName()
        );
    }
}
