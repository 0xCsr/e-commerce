package com.cesar.ecommerce.item.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * Use this method only for receiving data from put or patch request,
 * never return this DTO. Can exposure sensible data.
 * 
 * @author: César Missias
 * @version 1.0.0
 */

public record ItemDTO(
    @NotBlank(message = "Item name cannot be blank")
    String name,

    @NotBlank(message = "Item description cannot be blank")
    String description,

    @Positive
    BigDecimal price,

    @Positive
    int quantity
) {
    
}
