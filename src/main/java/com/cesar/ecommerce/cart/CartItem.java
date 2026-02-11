package com.cesar.ecommerce.cart;

import java.math.BigDecimal;

import com.cesar.ecommerce.BaseEntity;
import com.cesar.ecommerce.item.Item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cart_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItem extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Positive
    @Column(name = "unitary_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitaryPrice;

    @Positive
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
