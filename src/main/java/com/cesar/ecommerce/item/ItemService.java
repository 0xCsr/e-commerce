package com.cesar.ecommerce.item;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cesar.ecommerce.item.dto.CreateItemDTO;
import com.cesar.ecommerce.item.dto.ResponseItemDTO;
import com.cesar.ecommerce.user.Role;
import com.cesar.ecommerce.user.User;
import com.cesar.ecommerce.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResponseItemDTO save(UUID userId, CreateItemDTO dto) {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPermission() == Role.CUSTOMER) {
            throw new RuntimeException("Customer cannot create an Item");
        }

        return ResponseItemDTO.fromEntity(
            itemRepository.save(
                new Item(
                    user,
                    dto.name(),
                    dto.description(),
                    dto.price(),
                    dto.quantity()
                )
            )
        );
    }
}
