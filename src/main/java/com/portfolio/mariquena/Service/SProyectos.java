package com.portfolio.mariquena.Service;

import com.portfolio.mariquena.Entity.Proyectos;
import com.portfolio.mariquena.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
 @Autowired
    RProyectos rProyectos;
    

    //Mostrar
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }

    //Buscar id
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    //Buscar nombreEd
    public Optional<Proyectos> getByTitulo(String titulo){
        return rProyectos.findByTitulo(titulo);
    }
    
    //Guardar 
    public void save(Proyectos proyecto){
        rProyectos.save(proyecto);
    }
    
    //Eliminar ID
    public void delete(int id){
        rProyectos.deleteById(id);
    }

    
    //Existe id
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }

    
    //Existe nombre
    public boolean existsByTitulo(String titulo){
        return rProyectos.existsByTitulo(titulo);
    }

   
}

