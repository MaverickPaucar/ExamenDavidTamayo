package ec.edu.edu.arquitectura.examen.controller;

import org.springframework.http.ResponseEntity;
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


    @PutMapping
    public ResponseEntity<Edificio> update(@RequestBody Edificio edificio) {
        try {
            Edificio edificioRS = this.edificioService.update(edificio);
            return ResponseEntity.ok(edificioRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
