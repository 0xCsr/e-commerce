package com.cesar.ecommerce.user;

import java.util.UUID;

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
