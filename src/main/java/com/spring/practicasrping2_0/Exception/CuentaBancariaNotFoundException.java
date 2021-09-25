package com.spring.practicasrping2_0.Exception;

public class CuentaBancariaNotFoundException extends RuntimeException{

    public CuentaBancariaNotFoundException() {
    }

    public CuentaBancariaNotFoundException(Long cuentaID ) {
        super("Cuenta: " +cuentaID +" not found.");
    }
}
