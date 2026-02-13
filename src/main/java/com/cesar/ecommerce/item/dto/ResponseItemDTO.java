package com.cesar.ecommerce.item.dto;

import java.math.BigDecimal;

import com.cesar.ecommerce.item.Item;

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
