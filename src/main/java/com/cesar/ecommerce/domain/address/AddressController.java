package com.cesar.ecommerce.domain.address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesar.ecommerce.domain.address.dto.AddressDTO;
import com.cesar.ecommerce.domain.address.dto.CreateAddressDTO;
import com.cesar.ecommerce.domain.address.dto.ResponseAddressDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    
    private final AddressService addressService;

    @PostMapping("/userId/{userId}")
    public ResponseEntity<ResponseAddressDTO> createAddress(@PathVariable UUID userId, @RequestBody @Valid CreateAddressDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(userId, dto));
    }
    
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<ResponseAddressDTO>> findByUserId(@PathVariable UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByUserId(userId));
    }

    @PutMapping("/userId/{userId}/addressId/{addressId}")
    public ResponseEntity<ResponseAddressDTO> update(@PathVariable UUID userId, @PathVariable UUID addressId, @RequestBody AddressDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(userId, addressId, dto));
    }

    @DeleteMapping("/userId/{userId}/addressId/{addressId}")
    public void delete(@PathVariable UUID userId, @PathVariable UUID addressId) {
        addressService.delete(userId, addressId);
    }
}
