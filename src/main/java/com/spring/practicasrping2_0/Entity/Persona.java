package com.spring.practicasrping2_0.Entity;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Persona {

    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String email;
    private Date edad;


    public Persona() {

    }

    public Persona(String nombre, String apellidos, String telefono, String direccion, String email, Date edad) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getApellidos() {

        return apellidos;

    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;

    }

    public String getTelefono() {

        return telefono;

    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;

    }

    public String getDireccion() {

        return direccion;

    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public Date getEdad() {

        return edad;

    }

    public void setEdad(Date edad) {

        this.edad = edad;

    }
}
