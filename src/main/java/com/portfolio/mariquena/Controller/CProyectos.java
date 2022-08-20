
package com.portfolio.mariquena.Controller;

import com.portfolio.mariquena.Dto.dtoProyectos;
import com.portfolio.mariquena.Entity.Proyectos;
import com.portfolio.mariquena.Security.Controller.Mensaje;
import com.portfolio.mariquena.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;







@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins= "http://localhost:4200")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;

    
    //Traer
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos skills = sProyectos.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    //Borrar
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

// Crear
    @PostMapping("/create")
    public void create(@RequestBody Proyectos proyectos) {
        sProyectos.save(proyectos);
    }

 
    //Actualizar
    @PutMapping("/update")
    public void update(@RequestBody Proyectos proyectos) {
        
        sProyectos.save(proyectos);
        
    }
}