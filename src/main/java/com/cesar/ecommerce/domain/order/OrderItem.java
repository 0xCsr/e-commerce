package com.cesar.ecommerce.domain.order;

import java.math.BigDecimal;

import com.cesar.ecommerce.domain.BaseEntity;
import com.cesar.ecommerce.domain.item.Item;

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
@Table(name = "tb_order_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Positive
    @Column(name = "unitary_price", nullable = false)
    private BigDecimal unitaryPrice;

    @Positive
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
