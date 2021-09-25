package com.spring.practicasrping2_0.Exception;

public class OperacionNotFoundException extends RuntimeException{

    public OperacionNotFoundException() {
    }

    public OperacionNotFoundException(Long operacionID ) {
        super("Operacion " +operacionID +" not found.");
    }
}
