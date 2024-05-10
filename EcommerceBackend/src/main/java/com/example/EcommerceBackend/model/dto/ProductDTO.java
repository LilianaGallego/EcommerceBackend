package com.example.EcommerceBackend.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String nombre;
    private int cantidad;
    private double precio;
}
