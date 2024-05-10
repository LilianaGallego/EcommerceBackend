package com.example.EcommerceBackend.model.repository;

import com.example.EcommerceBackend.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    UserDTO save(UserDTO userDTO);
    List<UserDTO> findAll();
    Optional<UserDTO> findById(Long id);
    UserDTO update(UserDTO userDTO);
    void deleteById(Long id);
}
