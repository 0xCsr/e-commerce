package com.cesar.ecommerce.item.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateItemDTO(
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
