package com.cesar.ecommerce.address;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesar.ecommerce.user.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    
    List<Address> findByUser(User user);
}
