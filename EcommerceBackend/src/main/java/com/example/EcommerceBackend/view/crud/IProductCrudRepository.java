package com.example.EcommerceBackend.view.crud;

import com.example.EcommerceBackend.view.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCrudRepository extends JpaRepository<ProductEntity, Long> {
}
