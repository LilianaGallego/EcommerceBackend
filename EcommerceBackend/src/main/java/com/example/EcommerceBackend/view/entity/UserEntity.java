package com.example.EcommerceBackend.view.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
