package com.portfolio.mariquena.Repository;

import com.portfolio.mariquena.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REducacion extends JpaRepository<Educacion, Integer> {
    Optional<Educacion> findByTituloEd(String tituloEd);
    boolean existsByTituloEd(String tituloEd);
}