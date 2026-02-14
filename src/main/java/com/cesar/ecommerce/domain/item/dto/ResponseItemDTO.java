package com.cesar.ecommerce.domain.item.dto;

import java.math.BigDecimal;

import com.cesar.ecommerce.domain.item.Item;

public record ResponseItemDTO(
    String name,
    String description,
    BigDecimal price,
    int quantity
) {
    
    public static ResponseItemDTO fromEntity(Item item) {
        return new ResponseItemDTO(
            item.getName(),
            item.getDescription(),
            item.getPrice(),
            item.getQuantity()
        );
    }
}
