package com.cesar.ecommerce.domain.user.dto;

import java.util.UUID;

import com.cesar.ecommerce.domain.user.Role;
import com.cesar.ecommerce.domain.user.User;

public record UserResponseDTO(
    UUID id,
    String email,
    String firstName,
    Role permission
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getFirstName(),
            user.getPermission()
        );
    }
}
