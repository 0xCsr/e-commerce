package com.cesar.ecommerce.domain.address.dto;

import jakarta.validation.constraints.Pattern;

/**
 * Use this method only for receiving data from put or patch request,
 * never return this DTO. Can exposure sensible data.
 * 
 * @author: César Missias
 * @version 1.0.0
 */

public record AddressDTO(
    String country,
    String city,
    String street,
    @Pattern(regexp = "^\\d{5}-?\\d{3}$")
    String zipCode,
    String complement
) {
    
}
