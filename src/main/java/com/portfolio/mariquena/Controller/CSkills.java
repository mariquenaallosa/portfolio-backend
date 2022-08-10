package com.portfolio.mariquena.Controller;

import com.portfolio.mariquena.Dto.dtoSkills;
import com.portfolio.mariquena.Entity.Skills;
import com.portfolio.mariquena.Security.Controller.Mensaje;
import com.portfolio.mariquena.Service.SSkills;
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
@RequestMapping("/skills")
@CrossOrigin(origins= "http://localhost:4200")
public class CSkills  {
    @Autowired
    SSkills sSkills;

    
    //Traer
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")int id){
        if(!sSkills.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    //Borrar
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad cargada"), HttpStatus.OK);
    }

// Crear
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoSkills) {
        if (StringUtils.isBlank(dtoSkills.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        
        Skills skills = new Skills(dtoSkills.getSkillsLevel(), dtoSkills.getNombreSkill(),dtoSkills.getImgSkill());
        sSkills.save(skills);
      
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

 
    //Actualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoSkills) {
        if (!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        
        if (sSkills.existsByNombreSkill(dtoSkills.getNombreSkill()) && sSkills.getByNombreSkill(dtoSkills.getNombreSkill()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoSkills.getNombreSkill()))
            return new ResponseEntity(new Mensaje("La habilidad es obligatoria"), HttpStatus.BAD_REQUEST);

        Skills skills = sSkills.getOne(id).get();
        skills.setSkillsLevel(dtoSkills.getSkillsLevel());
        skills.setNombreSkill(dtoSkills.getNombreSkill());
        skills.setImgSkill(dtoSkills.getImgSkill());
        
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}

