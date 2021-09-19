package com.spring.practicasrping2_0.Form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaBancariaForm {

    private String IBAM;
    private String BIC;
    private boolean estado;
    private boolean numRojos;
    private double saldo;
    private String fechaApertura;

}
