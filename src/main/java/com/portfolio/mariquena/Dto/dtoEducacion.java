package com.portfolio.mariquena.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    @NotBlank
    private String tituloEd;
    @NotBlank 
    private String institucion;
    @NotNull
    private int fechaIngreso;
    @NotNull
    private int fechaFinal;
    @NotBlank
    private String descripcionEd;
    

    


    public dtoEducacion() {
    }

    public dtoEducacion(String tituloEd, String institucion, int fechaIngreso,int fechaFinal, String descripcionEd) {
        this.tituloEd = tituloEd;
        this.institucion = institucion;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinal = fechaFinal; 
        this.descripcionEd = descripcionEd;
    }

  

        
}
