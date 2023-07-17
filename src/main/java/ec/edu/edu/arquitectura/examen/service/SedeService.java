package ec.edu.edu.arquitectura.examen.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import ec.edu.edu.arquitectura.examen.model.Sede;
import ec.edu.edu.arquitectura.examen.repository.SedeRepository;
import jakarta.transaction.Transactional;

@Service
public class SedeService {
    private final SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public List<Sede> obtainByCodigoInstitucion(Integer codigo) {
        return this.sedeRepository.findByCodigoInstitucion(codigo);
    }

    public List<Sede> obtainAll() {
        return this.sedeRepository.findAll();
    }

    public Boolean hasDuplicates(List<?> list) {
        Set<Object> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    @Transactional
    public Sede create(Sede sede) {
        Sede sedeTmp = this.sedeRepository.findByNombre(sede.getNombre());
        if (sedeTmp == null) {
            List<Sede> sedes = this.obtainAll();
            Integer count = 0;
            for (Sede item : sedes) {
                if (item.getEsPrincipal()) {
                    count++;
                }
            }
            if (count >= 1) {
                throw new RuntimeException("Solo puede haber una sede principal");
            } else {
                sede.setFechaCreacion(new Date());
                return this.sedeRepository.save(sede);
            }
        } else {
            throw new RuntimeException("La sede ya existe.");
        }
    }
}
