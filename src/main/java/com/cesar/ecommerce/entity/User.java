package com.cesar.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    
    @Column(name = "email", updatable = true, nullable = false, unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name = "hash_password", updatable = true, nullable = false)
    private String hashPassword;

    @Column(name = "first_name", updatable = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", updatable = true, nullable = false)
    private String lastName;

    // DECIDIR DEPOIS
    // List<Address> addresses;
    // List<Role> permissions; || Role permission;
}
