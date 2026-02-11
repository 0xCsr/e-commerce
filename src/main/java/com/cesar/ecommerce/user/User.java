package com.cesar.ecommerce.user;

import java.util.ArrayList;
import java.util.List;

import com.cesar.ecommerce.BaseEntity;
import com.cesar.ecommerce.address.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    
    @Column(name = "email", updatable = true, nullable = false, unique = true)
    private String email;

    @Column(name = "hash_password", updatable = true, nullable = false)
    private String hashPassword;

    @Column(name = "first_name", updatable = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", updatable = true, nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "permission", updatable = true, nullable = false)
    private Role permission;
}
