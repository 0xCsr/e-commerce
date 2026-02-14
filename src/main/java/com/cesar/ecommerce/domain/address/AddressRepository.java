package com.cesar.ecommerce.domain.address;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesar.ecommerce.domain.user.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    
    List<Address> findByUser(User user);
}
