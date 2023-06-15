package ec.edu.edu.arquitectura.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.edu.arquitectura.examen.model.Institucion;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Integer>{
    
    
}
