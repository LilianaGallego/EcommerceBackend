package com.example.EcommerceBackend.view.repository;

import com.example.EcommerceBackend.model.dto.ProductDTO;
import com.example.EcommerceBackend.model.repository.IProductRepository;
import com.example.EcommerceBackend.view.crud.IProductCrudRepository;
import com.example.EcommerceBackend.view.entity.ProductEntity;
import com.example.EcommerceBackend.view.mapper.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepository implements IProductRepository {
    private final IProductMapper iProductMapper;
    private final IProductCrudRepository iProductCrudRepository;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = iProductMapper.toProductEntity(productDTO);
        return iProductMapper.toProductDto(iProductCrudRepository.save(productEntity));
    }

    @Override
    public List<ProductDTO> findAll() {
        return iProductMapper.toProductDtoList(iProductCrudRepository.findAll());
    }

    @Override
    public Optional<ProductDTO> findById(long id) {
        return iProductCrudRepository.findById(id)
                .map(iProductMapper::toProductDto);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return iProductMapper.toProductDto(iProductCrudRepository
                .save(iProductMapper.toProductEntity(productDTO)));
    }

    @Override
    public void deleteById(Long id) {
        iProductCrudRepository.deleteById(id);
    }
}
