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
public class CEducacion {
    @Autowired
   SEducacion sEducacion;

    public CEducacion(SEducacion sEducacion) {
        this.sEducacion = sEducacion;
    }

    
    //Traer
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> traerEducacion() {
        List <Educacion> educacion = sEducacion.traerEducacion();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu) {
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if (sEducacion.existsByTituloEd(dtoEdu.getTituloEd()) && sEducacion.getByTituloEd(dtoEdu.getTituloEd()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoEdu.getTituloEd()))
            return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoEdu.getDescripcionEd()))
            return new ResponseEntity(new Mensaje("la descripcion es obligatoria"), HttpStatus.BAD_REQUEST);

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setTituloEd(dtoEdu.getTituloEd());
        educacion.setDescripcionEd(dtoEdu.getDescripcionEd());
        educacion.setFechaEd(dtoEdu.getFechaEd());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("experiencia actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getTituloEd()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoEdu.getDescripcionEd()))
            return new ResponseEntity(new Mensaje("la descripcion del titulo es obligatoria"), HttpStatus.BAD_REQUEST);
        if (sEducacion.existsByTituloEd(dtoEdu.getTituloEd()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Educacion educacion = new Educacion (dtoEdu.getTituloEd(), dtoEdu.getDescripcionEd(), dtoEdu.getFechaEd(), dtoEdu.getImgEd());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

     @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        sEducacion.deleteEd(id);
        return new ResponseEntity(new Mensaje("experiencia eliminada"), HttpStatus.OK);
    }
}