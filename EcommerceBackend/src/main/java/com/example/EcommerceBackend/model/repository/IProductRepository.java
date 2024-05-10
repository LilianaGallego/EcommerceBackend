package com.example.EcommerceBackend.model.repository;



import com.example.EcommerceBackend.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> findAll();
    Optional<ProductDTO> findById(long id);
    ProductDTO update(ProductDTO productDTO);
    void deleteById(Long id);
}
