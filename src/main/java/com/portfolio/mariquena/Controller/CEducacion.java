package com.portfolio.mariquena.Controller;

import com.portfolio.mariquena.Entity.Educacion;
import com.portfolio.mariquena.Security.Controller.Mensaje;
import com.portfolio.mariquena.Service.SEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/educacion")
@CrossOrigin(origins= "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;

    
    //Traer
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!sEducacion.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }

// Crear
    @PostMapping("/create")
    public void create(@RequestBody Educacion educacion) {
        sEducacion.save(educacion);
    }

 
    //ACtualizar 
    @PutMapping("/update")
    public  void update(@RequestBody Educacion educacion) {
         System.out.println(educacion);    
        sEducacion.save(educacion);
    }
}