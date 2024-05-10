package com.example.EcommerceBackend.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String direccion;
    private String correo;
    private String telefono;
    private String contraseña;
    private boolean terminos;
}
