package com.portfolio.mariquena.Repository;

import com.portfolio.mariquena.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    Optional<Experiencia> findByNombreE(String nombreE);
    boolean existsByNombreE(String nombreE); 

    
    
}
