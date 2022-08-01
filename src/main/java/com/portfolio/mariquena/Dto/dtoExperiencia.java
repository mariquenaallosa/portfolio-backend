package com.portfolio.mariquena.Dto;

import java.util.Date;
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
    private Date fechaIngreso;
    @NotBlank
    private String descripcionExp;
    
            
    //Constructores

    public dtoExperiencia() {
        
    }

    public dtoExperiencia(String tituloExp, String empleador, Date fechaIngreso, String descripcionExp) {
        this.tituloExp = tituloExp;
        this.empleador = empleador;
        this.fechaIngreso = fechaIngreso;
        this.descripcionExp = descripcionExp;
    }
}