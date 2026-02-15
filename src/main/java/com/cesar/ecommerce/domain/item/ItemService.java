package com.cesar.ecommerce.domain.item;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cesar.ecommerce.domain.item.dto.CreateItemDTO;
import com.cesar.ecommerce.domain.item.dto.ItemDTO;
import com.cesar.ecommerce.domain.item.dto.ResponseItemDTO;
import com.cesar.ecommerce.domain.user.Role;
import com.cesar.ecommerce.domain.user.User;
import com.cesar.ecommerce.domain.user.UserRepository;

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

    public List<ResponseItemDTO> findAll() {
        return itemRepository.findAll()
            .stream()
            .map(ResponseItemDTO::fromEntity)
            .toList();
    }

    public ResponseItemDTO update(UUID userId, UUID itemId, ItemDTO dto) {

        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));

        if (!item.getUser().getId().equals(userId)) {
            throw new RuntimeException("User id dont matches with item user owner");
        }

        if (dto.name() != null) item.setName(dto.name());
        if (dto.description() != null) item.setDescription(dto.description());
        if (dto.price() != null) item.setPrice(dto.price());
        if (dto.quantity() > 0) item.setQuantity(dto.quantity());

        return null;
    }

    @Transactional
    public void delete(UUID id) {
        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item not found"));

        itemRepository.delete(item);
    }
}
