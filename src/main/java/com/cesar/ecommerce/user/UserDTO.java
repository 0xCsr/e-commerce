package com.cesar.ecommerce.user;

/**
 * Use this method only for receiving data from put or patch request,
 * never return this DTO. Can exposure sensible data.
 * 
 * @author: César Missias
 * @version 1.0.0
 */

public record UserDTO(
    String email,
    String password,
    String firstName,
    String lastName
    // List<AddressDTO> addresses,
    // Role permision // TODO: just an admin user can alter role permission.
) {

}
