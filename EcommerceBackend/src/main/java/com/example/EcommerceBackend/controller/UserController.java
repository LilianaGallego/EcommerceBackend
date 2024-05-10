package com.example.EcommerceBackend.controller;

import com.example.EcommerceBackend.model.dto.ResponseMessageDTO;
import com.example.EcommerceBackend.model.dto.UserDTO;
import com.example.EcommerceBackend.model.usecase.IUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final IUserUseCase userUseCase;
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseMessageDTO> save(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userUseCase.save(userDTO));
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userUseCase.findAll());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return ResponseEntity.of(userUseCase.update( id, userDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userUseCase.delete(id);
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.of(userUseCase.findById(id));
    }

}
