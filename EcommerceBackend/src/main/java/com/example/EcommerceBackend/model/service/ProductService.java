package com.example.EcommerceBackend.model.service;

import com.example.EcommerceBackend.model.dto.ProductDTO;
import com.example.EcommerceBackend.model.dto.ResponseMessageDTO;
import com.example.EcommerceBackend.model.repository.IProductRepository;
import com.example.EcommerceBackend.model.usecase.IProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductUseCase {
    private final IProductRepository iProductRepository;

    @Override
    public ResponseMessageDTO save(ProductDTO productDTO) {
        iProductRepository.save(productDTO);
        return new ResponseMessageDTO("Producto guardado correctamente");
    }

    @Override
    public List<ProductDTO> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<ProductDTO> findById(long id) {
        Optional<ProductDTO> productoDB = iProductRepository.findById(id);
        if (productoDB.isEmpty()) {
            return Optional.empty();
        }
        return productoDB;
    }

    @Override
    public Optional<ProductDTO> update(long id, ProductDTO productDTO) {
        Optional<ProductDTO> productoDB = iProductRepository.findById(id);
        if (productoDB.isEmpty()) {
            return Optional.empty();
        }
        else{
            productoDB.get().setNombre(productDTO.getNombre());
            productoDB.get().setPrecio(productDTO.getPrecio());
            productoDB.get().setCantidad(productDTO.getCantidad());
            productoDB.get().setPrecio(productDTO.getPrecio());
        }
        return Optional.of(iProductRepository.update(productoDB.get()));
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        Optional<ProductDTO> productoDB = iProductRepository.findById(id);
        HashMap<String, Object> json = new HashMap<>();
        if (productoDB.isEmpty()) {
            json.put("Mensaje", "El produto no ha sido encontrado");
        }
        iProductRepository.deleteById(id);
        json.put("Mensaje", "El produto ha sido eliminado");
        return new ResponseEntity<>(json, HttpStatus.OK);

    }
}
