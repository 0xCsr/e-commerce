package com.cesar.ecommerce.domain.address.dto;

import java.util.UUID;

import com.cesar.ecommerce.domain.address.Address;

public record ResponseAddressDTO(
    UUID addressId,
    UUID userId,
    String country,
    String city,
    String street,
    String zipCode,
    String complement
) {
    
    public static ResponseAddressDTO fromEntity(Address address) {
        return new ResponseAddressDTO(
            address.getId(),
            address.getUser().getId(),
            address.getCountry(),
            address.getCity(),
            address.getStreet(),
            address.getZipCode(),
            address.getComplement()
        );
    }
}
