package com.example.EcommerceBackend.view.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EcommerceBackend.view.entity.UserEntity;

public interface IUsercrudRepository extends JpaRepository<UserEntity, Long> {
}
