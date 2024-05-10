package com.example.EcommerceBackend.model.usecase;

import com.example.EcommerceBackend.model.dto.ResponseMessageDTO;
import com.example.EcommerceBackend.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserUseCase {
    ResponseMessageDTO save(UserDTO userDTO);
    List<UserDTO> findAll();
    Optional<UserDTO> findById(long id);
    Optional<UserDTO> update(long id, UserDTO userDTO);
    ResponseEntity<?> delete(long id);
}
