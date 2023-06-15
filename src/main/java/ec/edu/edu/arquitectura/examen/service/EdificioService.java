package ec.edu.edu.arquitectura.examen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.edu.arquitectura.examen.model.Edificio;
import ec.edu.edu.arquitectura.examen.repository.EdificioRepository;
import jakarta.transaction.Transactional;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    @Transactional
    public Edificio update(Edificio edificio) {
        Optional<Edificio> edificioOpt = this.edificioRepository.findById(edificio.getPk());
        if (edificioOpt.isPresent()) {
            Edificio edificioTmp = edificioOpt.get();
            edificioTmp.setNombre(edificio.getNombre());
            edificioTmp.setPiso(edificio.getPiso());
            edificioTmp.setSuperfice(edificio.getSuperfice());
            edificioTmp.setVersion(edificio.getVersion());
            this.edificioRepository.save(edificioTmp);
            return edificioTmp;
        } else {
            throw new RuntimeException("El impuesto que desea modificar no esta registrado");
        }
    }
}
