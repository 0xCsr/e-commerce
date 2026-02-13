package com.cesar.ecommerce.item;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesar.ecommerce.user.User;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    
    Optional<Item> findByUser(User user);
}
