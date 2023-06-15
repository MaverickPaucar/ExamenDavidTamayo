package ec.edu.edu.arquitectura.examen.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.edu.arquitectura.examen.model.Edificio;
import ec.edu.edu.arquitectura.examen.model.EdificioPK;

public interface EdificioRepository extends JpaRepository<Edificio, EdificioPK>{
    //List<Edificio> findBySedeOrderBySuperficeAsc(String codigo);
}
