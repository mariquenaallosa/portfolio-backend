package com.portfolio.mariquena.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String tituloEd;
    @NotBlank
    private String descripcionEd;
    @NotBlank
    private int fechaEd;
    
    private String imgEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String tituloEd, String descripcionEd, int fechaEd, String imgEd) {
        this.tituloEd = tituloEd;
        this.descripcionEd = descripcionEd;
        this.fechaEd = fechaEd;
        this.imgEd = imgEd;
    }

    public String getTituloEd() {
        return tituloEd;
    }

    public void setTituloEd(String tituloEd) {
        this.tituloEd = tituloEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

    public int getFechaEd() {
        return fechaEd;
    }

    public void setFechaEd(int fechaEd) {
        this.fechaEd = fechaEd;
    }

    public String getImgEd() {
        return imgEd;
    }

    public void setImgEd(String imgEd) {
        this.imgEd = imgEd;
    }
    
    
}
