package com.example.EcommerceBackend.exception;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException() {
        super("No tiene los permisos necesarios.");
    }
}
