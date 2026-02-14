package com.cesar.ecommerce.domain.address;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cesar.ecommerce.domain.address.dto.AddressDTO;
import com.cesar.ecommerce.domain.address.dto.CreateAddressDTO;
import com.cesar.ecommerce.domain.address.dto.ResponseAddressDTO;
import com.cesar.ecommerce.domain.user.User;
import com.cesar.ecommerce.domain.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResponseAddressDTO save(UUID userId, CreateAddressDTO dto) {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseAddressDTO.fromEntity(addressRepository.save(
            new Address(
                user,
                dto.country(),
                dto.city(),
                dto.street(),
                dto.zipCode(),
                dto.complement()
            )
        ));
    }

    @Transactional
    public List<ResponseAddressDTO> findByUserId(UUID userId) {
        
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        return addressRepository.findByUser(user)
            .stream()
            .map(ResponseAddressDTO::fromEntity)
            .toList();
    }

    @Transactional
    public ResponseAddressDTO update(UUID userId, UUID addressId, AddressDTO dto) {

        Address address = addressRepository.findById(addressId)
            .orElseThrow(() -> new RuntimeException("Address not found"));

        if (!address.getUser().getId().equals(userId)) {
            throw new RuntimeException("User id not matches with address user id");
        }

        if (dto.country() != null) address.setCountry(dto.country());
        if (dto.city() != null) address.setCity(dto.city());
        if (dto.street() != null) address.setStreet(dto.street());
        if (dto.zipCode() != null) address.setZipCode(dto.zipCode());
        if (dto.complement() != null) address.setComplement(dto.complement());
        
        return ResponseAddressDTO.fromEntity(addressRepository.save(address));
    }

    @Transactional
    public void delete(UUID userId, UUID addressId) {
        
        Address address = addressRepository.findById(addressId)
            .orElseThrow(() -> new RuntimeException("Address not found"));

        if (!address.getUser().getId().equals(userId)) {
            throw new RuntimeException("User is not owner of that address");
        }

        addressRepository.delete(address);
    }
}
