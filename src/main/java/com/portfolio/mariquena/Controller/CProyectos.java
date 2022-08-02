
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoproyectos.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción del proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        
        
        Proyectos proyectos = new Proyectos(dtoproyectos.getTitulo(),dtoproyectos.getDescripcion(),dtoproyectos.getImgUrl(),dtoproyectos.getDemoUrl(),dtoproyectos.getRepoUrl());
        sProyectos.save(proyectos);
      
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }

 
    //Actualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        if (!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        if (sProyectos.existsByTitulo(dtoproyectos.getTitulo()) && sProyectos.getByTitulo(dtoproyectos.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoproyectos.getTitulo()))
            return new ResponseEntity(new Mensaje("El proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoproyectos.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción del proyecto es obligatoria"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setTitulo(dtoproyectos.getTitulo());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());
       proyectos.setImgUrl(dtoproyectos.getImgUrl());
       proyectos.setRepoUrl(dtoproyectos.getRepoUrl());
       proyectos.setRepoUrl(dtoproyectos.getDemoUrl());
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}