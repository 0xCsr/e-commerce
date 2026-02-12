package com.cesar.ecommerce.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddressDTO(
    @NotBlank(message = "Country cannot be blank")
    String country,

    @NotBlank(message = "City cannot be blank")
    String city,

    @NotBlank(message = "Street cannot be blank")
    String street,

    @NotBlank(message = "Zip code cannot be blank")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$")
    String zipCode,

    String complement
) {
    
}
