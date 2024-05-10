package com.example.EcommerceBackend.view.mapper;

import com.example.EcommerceBackend.model.dto.ProductDTO;
import com.example.EcommerceBackend.view.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {


    ProductDTO toProductDto(ProductEntity productEntity);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(ProductDTO productDTO);
    List<ProductDTO> toProductDtoList(List<ProductEntity> productEntities);


}
