package com.portfolio.mariquena.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tituloEd;
    private String descripcionEd;
    private int fechaEd;
    private String imgEd;

    
    
    //Constructores

    public Educacion() {
    }

    public Educacion( String tituloEd, String descripcionEd, int fechaEd, String imgEd) {
    
        this.tituloEd = tituloEd;
        this.descripcionEd = descripcionEd;
        this.fechaEd = fechaEd;
        this.imgEd = imgEd;
    }

   //GYS

    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
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