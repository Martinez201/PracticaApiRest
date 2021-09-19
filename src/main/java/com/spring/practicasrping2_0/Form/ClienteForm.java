package com.spring.practicasrping2_0.Form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteForm {

    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String email;
    private Date edad;

}
