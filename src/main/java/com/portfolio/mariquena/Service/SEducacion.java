package com.portfolio.mariquena.Service;

import com.portfolio.mariquena.Entity.Educacion;
import com.portfolio.mariquena.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    
    @Autowired
    REducacion rEducacion;
    

    //Mostrar
    public List<Educacion> list(){
        return rEducacion.findAll();
    }

    //Buscar id
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    //Buscar nombreEd
    public Optional<Educacion> getByTituloEd(String tituloEd){
        return rEducacion.findByTituloEd(tituloEd);
    }
    
    //Guardar 
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    //Eliminar ID
    public void delete(int id){
        rEducacion.deleteById(id);
    }

    
    //Existe id
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }

    
    //Existe nombre
    public boolean existsByTituloEd(String tituloEd){
        return rEducacion.existsByTituloEd(tituloEd);
    }

   
}