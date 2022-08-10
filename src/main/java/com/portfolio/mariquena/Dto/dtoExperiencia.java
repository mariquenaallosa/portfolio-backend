package com.portfolio.mariquena.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class dtoExperiencia {
    @NotBlank
    private String tituloExp;
    @NotNull
    private String empleador;
    @NotNull
    private int fechaIngreso;
    @NotNull
    private int fechaFinal;
    @NotBlank
    private String descripcionExp;
    
            
    //Constructores

    public dtoExperiencia() {
        
    }

    public dtoExperiencia(String tituloExp, String empleador, int fechaIngreso,int fechaFinal, String descripcionExp) {
        this.tituloExp = tituloExp;
        this.empleador = empleador;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinal = fechaFinal;
        this.descripcionExp = descripcionExp;
    }
}