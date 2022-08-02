package com.portfolio.mariquena.Repository;

import com.portfolio.mariquena.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    Optional<Proyectos> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo); 
}
