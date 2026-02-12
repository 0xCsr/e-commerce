package com.cesar.ecommerce.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO save(CreateUserDTO dto) {

        if (userRepository.existsByEmail(dto.email().trim())) {
            throw new RuntimeException("Email already taken");
        }

        User user = userRepository.save(new User(
            dto.email().trim(),
            dto.password(), // TODO: implements bcrypt in security config after.
            dto.firstName().trim(),
            dto.lastName().trim(),
            new ArrayList<>(),
            Role.CUSTOMER
        ));

        return new UserResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getFirstName()
        );
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
            .map(UserResponseDTO::fromEntity)
            .collect(Collectors.toList());
    }

    public UserResponseDTO findById(UUID id) {
        return userRepository.findById(id)
            .map(UserResponseDTO::fromEntity)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserResponseDTO findByEmail(String email) {
        return userRepository.findByEmail(email)
            .map(UserResponseDTO::fromEntity)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
