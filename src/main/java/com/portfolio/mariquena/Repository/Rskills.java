
package com.portfolio.mariquena.Repository;

import com.portfolio.mariquena.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rskills extends JpaRepository <Skills, Integer>{
    Optional<Skills> findByNombreSkill(String nombreSkill);
    boolean existsByNombreSkill(String nombreSkill); 
}
