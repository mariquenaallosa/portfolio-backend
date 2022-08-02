/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mariquena.Service;

import com.portfolio.mariquena.Entity.Skills;
import com.portfolio.mariquena.Repository.Rskills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
     
    @Autowired
    Rskills rSkills;
    

    //Mostrar
    public List<Skills> list(){
        return rSkills.findAll();
    }

    //Buscar id
    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
    
    //Buscar nombreEd
    public Optional<Skills> getByNombreSkill(String nombreSkill){
        return rSkills.findByNombreSkill(nombreSkill);
    }
    
    //Guardar 
    public void save(Skills skill){
        rSkills.save(skill);
    }
    
    //Eliminar ID
    public void delete(int id){
        rSkills.deleteById(id);
    }

    
    //Existe id
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }

    
    //Existe nombre
    public boolean existsByNombreSkill(String nombreSkill){
        return rSkills.existsByNombreSkill(nombreSkill);
    }

   
}

