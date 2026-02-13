package com.cesar.ecommerce.item;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesar.ecommerce.item.dto.CreateItemDTO;
import com.cesar.ecommerce.item.dto.ResponseItemDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {
    
    private final ItemService itemService;

    @PostMapping("/userId/{userId}")
    public ResponseEntity<ResponseItemDTO> createItem(@PathVariable UUID userId, @RequestBody @Valid CreateItemDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(userId, dto));
    }

    @GetMapping
    public ResponseEntity<List<ResponseItemDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }
}
