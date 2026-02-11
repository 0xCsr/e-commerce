package com.cesar.ecommerce.item;

import java.math.BigDecimal;

import com.cesar.ecommerce.BaseEntity;
import com.cesar.ecommerce.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item extends BaseEntity {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Item name cannot be blank")
    @Column(name = "name", updatable = true, nullable = false)
    private String name;

    @NotBlank(message = "Item description cannot be blank")
    @Column(name = "description", updatable = true, nullable = false)
    private String description;

    @Positive
    @Column(name = "price", updatable = true, nullable = false)
    private BigDecimal price;

    @PositiveOrZero
    @Column(name = "quantity", updatable = true, nullable = false, precision = 15, scale = 2)
    private Integer quantity;
}
