package com.example.EcommerceBackend.model.usecase;

import com.example.EcommerceBackend.model.dto.ProductDTO;
import com.example.EcommerceBackend.model.dto.ResponseMessageDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductUseCase {
    ResponseMessageDTO save(ProductDTO productDTO);
    List<ProductDTO> findAll();
    Optional<ProductDTO> findById(long id);
    Optional<ProductDTO> update(long id, ProductDTO productDTO);
    ResponseEntity<?> delete(long id);

}
