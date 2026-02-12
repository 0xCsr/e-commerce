package com.cesar.ecommerce.address.dto;

import java.util.UUID;

import com.cesar.ecommerce.address.Address;

public record ResponseAddressDTO(
    UUID userId,
    String country,
    String city,
    String street,
    String zipCode,

    String complement
) {
    
    public static ResponseAddressDTO fromEntity(Address address) {
        return new ResponseAddressDTO(
            address.getUser().getId(),
            address.getCountry(),
            address.getCity(),
            address.getStreet(),
            address.getZipCode(),
            address.getComplement()
        );
    }
}
