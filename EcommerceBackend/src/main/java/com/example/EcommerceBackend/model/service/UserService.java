package com.example.EcommerceBackend.model.service;


import com.example.EcommerceBackend.model.dto.ResponseMessageDTO;
import com.example.EcommerceBackend.model.dto.UserDTO;
import com.example.EcommerceBackend.model.repository.IUserRepository;
import com.example.EcommerceBackend.model.usecase.IUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserUseCase {
    private final IUserRepository iUserRepository;
    @Override
    public ResponseMessageDTO save(UserDTO userDTO) {
        iUserRepository.save(userDTO);
        return new ResponseMessageDTO("Usuario guardado correctamente");
    }

    @Override
    public List<UserDTO> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<UserDTO> findById(long id) {
        Optional<UserDTO> userDB = iUserRepository.findById(id);
        if (userDB.isEmpty()) {
            return Optional.empty();
        }
        return userDB;
    }

    @Override
    public Optional<UserDTO> update(long id, UserDTO userDTO) {
        Optional<UserDTO> userDB = iUserRepository.findById(id);
        if (userDB.isEmpty()) {
            return Optional.empty();
        }else{
            userDB.get().setNombres(userDTO.getNombres());
            userDB.get().setApellidos(userDTO.getApellidos());
            userDB.get().setCiudad(userDTO.getCiudad());
            userDB.get().setDireccion(userDTO.getDireccion());
            userDB.get().setCorreo(userDTO.getCorreo());
            userDB.get().setTelefono(userDTO.getTelefono());
            userDB.get().setContraseña(userDTO.getContraseña());
            userDB.get().setTerminos(userDTO.isTerminos());
        }
        return Optional.of(iUserRepository.update(userDB.get()));
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        Optional<UserDTO> userDB = iUserRepository.findById(id);
        HashMap<String, Object> json = new HashMap<>();
        if (userDB.isEmpty()) {
            json.put("Mensaje", "El usuario no ha sido encontrado");
        }
        iUserRepository.deleteById(id);
        json.put("Mensaje", "El usuario ha sido eliminado");
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
