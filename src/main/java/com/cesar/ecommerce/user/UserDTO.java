package com.cesar.ecommerce.user;

public record UserDTO(
    String email,
    String password,
    String firstName,
    String lastName
    // List<AddressDTO> addresses,
    // Role permision // TODO: just an admin user can alter role permission.
) {
    
}
