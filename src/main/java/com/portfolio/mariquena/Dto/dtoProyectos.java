package com.portfolio.mariquena.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyectos {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgUrl;
    @NotBlank
    private String demoUrl;
    @NotBlank
    private String repoUrl;
    
            
    //Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String titulo, String descripcion, String imgUrl, String demoUrl, String repoUrl) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.demoUrl = demoUrl;
        this.repoUrl = repoUrl;
    }

    
}
