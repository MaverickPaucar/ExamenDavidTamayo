package ec.edu.edu.arquitectura.examen.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.edu.arquitectura.examen.model.Sede;
import ec.edu.edu.arquitectura.examen.service.SedeService;

@RestController
@RequestMapping("/api/v1/sedes")
public class SedeController {
    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<Sede>> obtainByCodigoInstitucion(@PathVariable(name = "code") Integer code) {
        List<Sede> sede = this.sedeService.obtainByCodigoInstitucion(code);
        if (sede.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        } else {
            return ResponseEntity.ok(sede);
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Sede sede) {
        try {
            //Sede sedeRS = this.sedeService.create(sede);
            this.sedeService.create(sede);
            return ResponseEntity.ok("Operación exitosa");
        } catch (RuntimeException rte) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rte.getMessage());
        }
    }
    
}
