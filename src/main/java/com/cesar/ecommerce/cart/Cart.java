package com.cesar.ecommerce.cart;

import com.cesar.ecommerce.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
}
