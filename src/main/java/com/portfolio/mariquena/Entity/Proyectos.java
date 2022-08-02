/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mariquena.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String descripcion;
    @Column(name="img_url")
    private String imgUrl;
    @Column(name="demo_url")
    private String demoUrl;
    @Column(name="repo_url")
    private String repoUrl;

    public Proyectos() {
    }

    public Proyectos(String titulo, String descripcion, String imgUrl, String demoUrl, String repoUrl) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.demoUrl = demoUrl;
        this.repoUrl = repoUrl;
    }

    public Proyectos(int id, String titulo, String descripcion, String imgUrl, String demoUrl, String repoUrl) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.demoUrl = demoUrl;
        this.repoUrl = repoUrl;
    }
    
    
    
}
