package com.spring.practicasrping2_0.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"operaciones","titulares"})

@Entity
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String IBAM;
    private String BIC;
    private boolean estado;
    private boolean numRojos;
    private double saldo;
    private String fechaApertura;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "cuenta_titular",
            joinColumns = @JoinColumn(name = "titular_id"),
            inverseJoinColumns = @JoinColumn(name = "cuenta_id"))
    private List<Cliente> titulares;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "cuenta_operaciones",
            joinColumns = @JoinColumn(name = "cuenta_id"),
            inverseJoinColumns = @JoinColumn(name = "operacion_id"))
    private List<Operacion> operaciones;
}
