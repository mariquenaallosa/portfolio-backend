package com.portfolio.mariquena.Controller;

import com.portfolio.mariquena.Entity.Persona;
import com.portfolio.mariquena.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    
   //Declarando métodos 
    //Pide 
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    //Desde el front guardame esto en la base de datos
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada con éxito";
    }
    
    
    
    //Borrar persona
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String seletePersona (@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada con éxito";
    }
    
    
    
    //Editar persona
    
    //URL:PUERTO/personas/editar/4?nombre&apellido&img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("about") String nuevoAbout,
            @RequestParam("linkedinUrl")String nuevoLinkedinUrl,
            @RequestParam("githubUrl") String nuevoGithubUrl,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("bannerUrl") String nuevoBannerUrl,
            @RequestParam("photoUrl") String nuevoPhotoUrl){
       Persona persona= ipersonaService.findPersona(id);
       
       
       persona.setNombre(nuevoNombre);
       persona.setApellido(nuevoApellido);
       persona.setTitulo(nuevoTitulo);
       persona.setAbout(nuevoAbout);
       persona.setLinkedinUrl(nuevoLinkedinUrl);
       persona.setGithubUrl(nuevoGithubUrl);
       persona.setEmail(nuevoEmail);
       persona.setBannerUrl(nuevoBannerUrl);
       persona.setPhotoUrl(nuevoPhotoUrl);
       
       
       
       
       ipersonaService.savePersona(persona);
       return persona;
       
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
     return ipersonaService.findPersona((long)1);
    }
}
