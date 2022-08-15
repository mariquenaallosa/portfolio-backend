
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
public class Experiencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="titulo_exp")
    private String tituloExp;
    private String empleador;
    
    @Column(name="fecha_ingreso")
    private int fechaIngreso;
     @Column(name="fecha_final")
    private int fechaFinal;
    
    
    @Column(name="descripcion_e")
    private String descripcionE;
    
    
  
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String tituloExp, String empleador, int fechaIngreso,int fechaFinal, String descripcionE) {
        this.tituloExp = tituloExp;
        this.empleador = empleador;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinal = fechaFinal;
        this.descripcionE = descripcionE;
    }

    public Experiencia(int id, String tituloExp, String empleador, int fechaIngreso,int fechaFinal, String descripcionE) {
        this.id = id;
        this.tituloExp = tituloExp;
        this.empleador = empleador;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinal = fechaFinal;
        this.descripcionE = descripcionE;
    }

       
}