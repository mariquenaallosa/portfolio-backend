package com.portfolio.mariquena.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="titulo_ed")
    private String tituloEd;

    private String institucion;
    
    
    @Column(name="fecha_ingreso")
    private int fechaIngreso;
    
    @Column(name="fecha_final")
    private int fechaFinal;
    
    
    @Column (name="descripcion_ed")    
    private String descripcionEd;
    
    @Column (name="img_url")
    private String imgUrl;

    
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String tituloEd, String institucion, int fechaIngreso,int fechaFinal, String descripcionEd,String imgUrl) {
        this.tituloEd = tituloEd;
        this.institucion = institucion;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinal = fechaFinal;
        this.descripcionEd = descripcionEd;
        this.imgUrl = imgUrl;
        
    }


    public Educacion(int id, String tituloEd, String institucion, int fechaIngreso,int fechaFinal, String descripcionEd,String imgUrl) {
        this.id = id;
        this.tituloEd = tituloEd;
        this.institucion = institucion;
        this.fechaIngreso = fechaIngreso;
        this.descripcionEd = descripcionEd;
        this.imgUrl = imgUrl;
    }

    


}