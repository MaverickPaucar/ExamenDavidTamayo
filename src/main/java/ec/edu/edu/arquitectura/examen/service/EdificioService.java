package ec.edu.edu.arquitectura.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.edu.arquitectura.examen.model.Edificio;
import ec.edu.edu.arquitectura.examen.model.Sede;
import ec.edu.edu.arquitectura.examen.repository.EdificioRepository;
import ec.edu.edu.arquitectura.examen.repository.SedeRepository;
import jakarta.transaction.Transactional;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;
    private final SedeRepository sedeRepository;

    

    public EdificioService(EdificioRepository edificioRepository, SedeRepository sedeRepository) {
        this.edificioRepository = edificioRepository;
        this.sedeRepository = sedeRepository;
    }

    public List<Edificio> obtainBySedeId(String sedeId){
        Optional<Sede> sedeOpt = this.sedeRepository.findById(sedeId);
        Sede sede = sedeOpt.get();
        if(sede == null){
            throw new RuntimeException("la sede con Id: "+ sedeId+ " no existe");
        }else{
            List<Edificio> edificios = this.edificioRepository.findBySedeOrderBySuperficeDesc(sede);
            return edificios;
        }
        
    }

    @Transactional
    public Edificio update(Edificio edificio) {
        Optional<Edificio> edificioOpt = this.edificioRepository.findById(edificio.getPk());
        if (edificioOpt.isPresent()) {
            Edificio edificioTmp = edificioOpt.get();
            edificioTmp.setNombre(edificio.getNombre());
            edificioTmp.setPiso(edificio.getPiso());
            edificioTmp.setSuperfice(edificio.getSuperfice());
            this.edificioRepository.save(edificioTmp);
            return edificioTmp;
        } else {
            throw new RuntimeException("El impuesto que desea modificar no esta registrado");
        }
    }
}
