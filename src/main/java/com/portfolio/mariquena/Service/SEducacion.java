/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private final REducacion rEducacion;
    
    @Autowired
    public SEducacion(REducacion rEducacion){
    this.rEducacion= rEducacion;
    }

    //Mostrar
    public List<Educacion> traerEducacion(){
        return rEducacion.findAll();
    }

    
    //Guardar 
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    
    //Buscar id
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }

    
    //Buscar nombreEd
    public Optional<Educacion> getByTituloEd(String tituloEd){
        return rEducacion.findByTituloEd(tituloEd);
    }

    
    //Eliminar ID
    public void deleteEd(int id){
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