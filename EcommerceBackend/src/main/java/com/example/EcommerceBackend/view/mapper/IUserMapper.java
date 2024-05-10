package com.example.EcommerceBackend.view.mapper;

import com.example.EcommerceBackend.model.dto.UserDTO;
import com.example.EcommerceBackend.view.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserDTO toUserDTO(UserEntity userEntity);
    UserEntity toUserEntity(UserDTO userDTO);

    List<UserDTO> toUserDTOList(List<UserEntity> userEntities);
}
