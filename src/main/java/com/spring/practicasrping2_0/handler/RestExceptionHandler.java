package com.spring.practicasrping2_0.handler;

import com.spring.practicasrping2_0.Exception.ClienteNotFoundException;
import com.spring.practicasrping2_0.Exception.CuentaBancariaNotFoundException;
import com.spring.practicasrping2_0.Exception.OperacionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = {ClienteNotFoundException.class})
    public ResponseEntity clientNotFound(ClienteNotFoundException ex, WebRequest request) {
        log.debug("handling ClientNotFoundException...");
        return notFound().build();
    }

    @ExceptionHandler(value = {OperacionNotFoundException.class})
    public ResponseEntity operationNotFound(OperacionNotFoundException ex, WebRequest request) {
        log.debug("handling OperacionNotFoundException...");
        return notFound().build();
    }

    @ExceptionHandler(value = {CuentaBancariaNotFoundException.class})
    public ResponseEntity bankAccountNotFound(CuentaBancariaNotFoundException ex, WebRequest request) {
        log.debug("handling CuentaBancariaNotFoundException...");
        return notFound().build();
    }

 /*   @ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {
        log.debug("handling InvalidJwtAuthenticationException...");
        return status(UNAUTHORIZED).build();
    }*/

}
