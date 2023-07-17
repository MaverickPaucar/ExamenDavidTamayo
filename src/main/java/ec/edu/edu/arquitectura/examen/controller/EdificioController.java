package ec.edu.edu.arquitectura.examen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.edu.arquitectura.examen.model.Edificio;
import ec.edu.edu.arquitectura.examen.service.EdificioService;

@RestController
@RequestMapping("/api/v1/edificios")
public class EdificioController {

    private final EdificioService edificioService;

    
    public EdificioController(EdificioService edificioService) {
        this.edificioService = edificioService;
    }

    @GetMapping("/{sedeId}")
    public ResponseEntity<List<Edificio>> obtainBySedeId(@PathVariable(name = "sedeId") String sedeID) {
        List<Edificio> edificios = this.edificioService.obtainBySedeId(sedeID);
        if (edificios.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        } else {
            return ResponseEntity.ok(edificios);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Edificio> update(@RequestBody Edificio edificio) {
        try {
            Edificio edificioRS = this.edificioService.update(edificio);
            return ResponseEntity.ok(edificioRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
