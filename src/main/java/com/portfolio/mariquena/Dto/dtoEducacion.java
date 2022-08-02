package com.portfolio.mariquena.Dto;

import java.util.Date;
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
    private Date fechaIngreso;
    @NotBlank
    private String descripcionEd;
    

    


    public dtoEducacion() {
    }

    public dtoEducacion(String tituloEd, String institucion, Date fechaIngreso, String descripcionEd) {
        this.tituloEd = tituloEd;
        this.institucion = institucion;
        this.fechaIngreso = fechaIngreso;
        this.descripcionEd = descripcionEd;
    }

  

        
}
