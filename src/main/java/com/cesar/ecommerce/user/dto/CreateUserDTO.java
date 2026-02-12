package com.cesar.ecommerce.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
    @NotBlank(message = "Email cannot be blank")
    @Email
    String email,

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be have min 8 characters")
    String password,

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 255)
    String firstName,

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 255)
    String lastName
) {
    
}
