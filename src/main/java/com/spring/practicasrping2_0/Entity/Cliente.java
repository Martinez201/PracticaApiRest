package com.spring.practicasrping2_0.Entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Persona datosPersonales;


    @ManyToMany(mappedBy = "titulares",fetch = FetchType.EAGER)
    private List<CuentaBancaria> cuentasBancarias;

    public Cliente(){

    }

    public Cliente(String nombre, String apellidos, String telefono, String direccion, String email, Date edad){

        this.datosPersonales = new Persona(nombre,apellidos,telefono,direccion,email,edad);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getDatosPersonales() {

        return datosPersonales;

    }

    public void setDatosPersonales(Persona datosPersonales) {

        this.datosPersonales = datosPersonales;

    }

    public List<CuentaBancaria> getCuentasBancarias() {

        return cuentasBancarias;

    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {

        this.cuentasBancarias = cuentasBancarias;

    }


}
