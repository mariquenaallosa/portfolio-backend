package com.portfolio.mariquena.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;



@Getter @Setter
@Entity
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   
    @Column(name="titulo_ed")
    private String tituloEd;

    private String institucion;
    
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @Column(name="fecha_ingreso")
    private Date fechaIngreso;
    
    
    
    @Column (name="descripcion_ed")    
    private String descripcionEd;



    
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String tituloEd, String institucion, Date fechaIngreso, String descripcionEd) {
        this.tituloEd = tituloEd;
        this.institucion = institucion;
        this.fechaIngreso = fechaIngreso;
        this.descripcionEd = descripcionEd;
    }


    public Educacion(int id, String tituloEd, String institucion, Date fechaIngreso, String descripcionEd) {
        this.id = id;
        this.tituloEd = tituloEd;
        this.institucion = institucion;
        this.fechaIngreso = fechaIngreso;
        this.descripcionEd = descripcionEd;
    }

    


}