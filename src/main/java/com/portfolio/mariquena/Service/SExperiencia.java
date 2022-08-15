package com.portfolio.mariquena.Service;

import com.portfolio.mariquena.Entity.Experiencia;
import com.portfolio.mariquena.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
     @Autowired
     RExperiencia rExperiencia;
     
    
    //Enlista
     public List<Experiencia> list(){
         return rExperiencia.findAll();
     }
     
    
    //Busca por id
     public Optional<Experiencia> getOne(int id){
         return rExperiencia.findById(id);
     }
     
    //Busca por nombre
     public Optional<Experiencia> getByNombreE(String TituloExp){
         return rExperiencia.findByTituloExp(TituloExp);
     }
     //
     public void save(Experiencia experiencia){
         rExperiencia.save(experiencia);
     }
     
    //Borrar por id
    
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     
    
    //Buscar por id y nombre 
     public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     
     public boolean existsByNombreE(String TituloExp){
         return rExperiencia.existsByTituloExp(TituloExp);
     }
    
    
    
}