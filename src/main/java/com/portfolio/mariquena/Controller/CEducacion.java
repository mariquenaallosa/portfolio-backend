package com.portfolio.mariquena.Controller;

import com.portfolio.mariquena.Dto.dtoEducacion;
import com.portfolio.mariquena.Entity.Educacion;
import com.portfolio.mariquena.Security.Controller.Mensaje;
import com.portfolio.mariquena.Service.SEducacion;
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
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }

// Crear
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getTituloEd()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sEducacion.existsByTituloEd(dtoEdu.getTituloEd()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoEdu.getDescripcionEd()))
            return new ResponseEntity(new Mensaje("La descripcion del titulo es obligatoria"), HttpStatus.BAD_REQUEST);
        
        
        Educacion educacion = new Educacion(dtoEdu.getTituloEd(),dtoEdu.getInstitucion(),dtoEdu.getFechaIngreso(), dtoEdu.getDescripcionEd());
        sEducacion.save(educacion);
      
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

 
    //ACtualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu) {
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        if (sEducacion.existsByTituloEd(dtoEdu.getTituloEd()) && sEducacion.getByTituloEd(dtoEdu.getTituloEd()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoEdu.getTituloEd()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoEdu.getDescripcionEd()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setTituloEd(dtoEdu.getTituloEd());
        educacion.setDescripcionEd(dtoEdu.getDescripcionEd());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
}