package com.example.EcommerceBackend.controller;

import com.example.EcommerceBackend.model.dto.ProductDTO;
import com.example.EcommerceBackend.model.dto.ResponseMessageDTO;
import com.example.EcommerceBackend.model.dto.UserDTO;
import com.example.EcommerceBackend.model.usecase.IProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/products")
public class ProductCotroller {

    private final IProductUseCase productUseCase;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseMessageDTO> save(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productUseCase.save(productDTO));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/findAll")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productUseCase.findAll());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        return ResponseEntity.of(productUseCase.update( id, productDTO));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return productUseCase.delete(id);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.of(productUseCase.findById(id));
    }
}
