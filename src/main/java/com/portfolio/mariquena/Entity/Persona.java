
package com.portfolio.mariquena.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;





@Getter @Setter
@Entity
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min=1, max=50, message="No cumple con la longitud necesaria")
    private String nombre;
      
    @NotNull
    @Size (min=1, max=50, message="No cumple con la longitud necesaria")
    private String apellido;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String about;
    
    @NotNull
    @Column(name="linkedin_url")
    private String linkedinUrl;
    
    @NotNull
    @Column(name="github_url")
    private String githubUrl;
    
    @NotNull
    @Column(name="email")
    private String email;
    
    @Column(name="banner_url")
    private String bannerUrl;
    
    @Size (min=1, max=50, message="No cumple con la condición")
    @Column(name="photo_url")
    private String photoUrl;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, String about, String linkedinUrl, String githubUrl, String email, String bannerUrl, String photoUrl) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.about = about;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.email = email;
        this.bannerUrl = bannerUrl;
        this.photoUrl = photoUrl;
    }
    
    
}
