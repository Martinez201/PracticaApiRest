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
public class OperacionForm {

    private Date fecha;
    private String concepto;
    private double cantidad;

}
