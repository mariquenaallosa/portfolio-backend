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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="https://mariquena-allosa.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    
   //Declarando métodos 
    //Pide 
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    //Desde el front guardame esto en la base de datos
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
    //URL:PUERTO/personas/editar
    @PutMapping("/personas/update")
    public String editPersona(@RequestBody Persona persona){
        //Persona personas = ipersonaService.findPersona((long)1);
        ipersonaService.savePersona(persona);
        return "Actualizado los datos";
    }
    
    //@GetMapping("/personas/traer/perfil")
   // public Persona findPersona(){
     //return ipersonaService.findPersona((long)1);
    //}
}
