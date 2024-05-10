package com.example.EcommerceBackend.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException() {
        super("El usuario ingresado ya se encuentra registrado.");
    }
}
