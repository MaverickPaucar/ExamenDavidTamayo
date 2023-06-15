package ec.edu.edu.arquitectura.examen.service;


import java.util.List;
import java.util.Optional;

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
    
public List<Sede> obtainByCodigoSede(Integer codigo){
    return this.sedeRepository.findByCodigoInstitucion(codigo);
}


@Transactional
public Sede create(Sede sede){
    Optional<Sede> sedeOpt = this.sedeRepository.findById(sede.getCodigo());
    Sede sedeTmp = sedeOpt.get();
    if(sedeTmp == null){
        return this.sedeRepository.save(sede);
    }else{
        throw new RuntimeException("La sede ya existe.");
    }
}
    
}
