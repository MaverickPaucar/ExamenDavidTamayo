package ec.edu.edu.arquitectura.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.edu.arquitectura.examen.model.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, String> {
    List<Sede> findByCodigoInstitucion(Integer codigo);

    Sede findByEsPrincipal(Boolean esPrincipal);
}
