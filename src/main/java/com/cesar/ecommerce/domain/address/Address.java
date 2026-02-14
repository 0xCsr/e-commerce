package com.cesar.ecommerce.address;

import com.cesar.ecommerce.BaseEntity;
import com.cesar.ecommerce.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "country", updatable = true, nullable = false)
    private String country;

    @Column(name = "city", updatable = true, nullable = false)
    private String city;

    @Column(name = "street", updatable = true, nullable = false)
    private String street;

    @Pattern(regexp = "^\\d{5}-?\\d{3}$")
    @Column(name = "zip_code", updatable = true, nullable = false)
    private String zipCode;

    @Column(name = "complement", updatable = true)
    private String complement;
}
