package ec.edu.edu.arquitectura.examen.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.edu.arquitectura.examen.model.Edificio;
import ec.edu.edu.arquitectura.examen.model.EdificioPK;
import ec.edu.edu.arquitectura.examen.model.Sede;

public interface EdificioRepository extends JpaRepository<Edificio, EdificioPK>{
    //List<Edificio> findAllByOrderBySuperficeDesc();
    List<Edificio> findBySedeOrderBySuperficeDesc(Sede sede);
}
