package com.spring.practicasrping2_0.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fecha;
    private String concepto;
    private double cantidad;

    @ManyToMany(mappedBy = "operaciones",fetch = FetchType.EAGER)
    private List<CuentaBancaria> cuentaBancaria;

    public Operacion() {

    }

    public Operacion(Date fecha, String concepto, double cantidad) {

        this.fecha = fecha;
        this.concepto = concepto;
        this.cantidad = cantidad;

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public Date getFecha() {

        return fecha;

    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;

    }

    public String getConcepto() {

        return concepto;

    }

    public void setConcepto(String concepto) {

        this.concepto = concepto;

    }

    public double getCantidad() {

        return cantidad;

    }

    public void setCantidad(double cantidad) {

        this.cantidad = cantidad;

    }

    public List<CuentaBancaria> getCuentaBancaria() {

        return cuentaBancaria;

    }

    public void setCuentaBancaria(List<CuentaBancaria> cuentaBancaria) {

        this.cuentaBancaria = cuentaBancaria;

    }
}
