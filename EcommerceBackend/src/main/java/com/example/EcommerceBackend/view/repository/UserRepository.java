package com.example.EcommerceBackend.view.repository;

import com.example.EcommerceBackend.model.dto.UserDTO;
import com.example.EcommerceBackend.model.repository.IUserRepository;
import com.example.EcommerceBackend.view.crud.IUsercrudRepository;
import com.example.EcommerceBackend.view.entity.UserEntity;
import com.example.EcommerceBackend.view.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository implements IUserRepository {
    private final IUsercrudRepository iUsercrudRepository;
    private final IUserMapper iUserMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = iUserMapper.toUserEntity(userDTO);
        return iUserMapper.toUserDTO(iUsercrudRepository.save(userEntity));
    }

    @Override
    public List<UserDTO> findAll() {
        return iUserMapper.toUserDTOList(iUsercrudRepository.findAll());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return iUsercrudRepository.findById(id)
                .map(iUserMapper::toUserDTO);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return iUserMapper.toUserDTO(iUsercrudRepository
                .save(iUserMapper.toUserEntity(userDTO)));
    }

    @Override
    public void deleteById(Long id) {
        iUsercrudRepository.deleteById(id);
    }
}
