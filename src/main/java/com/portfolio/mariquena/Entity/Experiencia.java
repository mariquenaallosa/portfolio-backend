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
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Getter @Setter
@Entity
public class Experiencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="titulo_exp")
    private String tituloExp;
    private String empleador;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    @Column(name="fecha_ingreso")
    private Date fechaIngreso;
    @Column(name="descripcion_e")
    private String descripcionE;
    
    
  
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String tituloExp, String empleador, Date fechaIngreso, String descripcionE) {
        this.tituloExp = tituloExp;
        this.empleador = empleador;
        this.fechaIngreso = fechaIngreso;
        this.descripcionE = descripcionE;
    }

    public Experiencia(int id, String tituloExp, String empleador, Date fechaIngreso, String descripcionE) {
        this.id = id;
        this.tituloExp = tituloExp;
        this.empleador = empleador;
        this.fechaIngreso = fechaIngreso;
        this.descripcionE = descripcionE;
    }

       
}
