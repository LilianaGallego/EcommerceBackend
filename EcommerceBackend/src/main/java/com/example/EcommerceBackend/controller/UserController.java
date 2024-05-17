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

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseMessageDTO> save(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userUseCase.save(userDTO));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/findAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userUseCase.findAll());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return ResponseEntity.of(userUseCase.update( id, userDTO));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userUseCase.delete(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.of(userUseCase.findById(id));
    }

}
