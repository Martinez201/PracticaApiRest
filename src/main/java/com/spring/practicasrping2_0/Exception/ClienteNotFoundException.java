package com.spring.practicasrping2_0.Exception;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException() {
    }

    public ClienteNotFoundException(Long usuarioID ) {
        super("Cliente: " +usuarioID +" not found.");
    }
}
