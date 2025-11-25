package edu.udistrital.acm.proyecto_final.controller;

import edu.udistrital.acm.proyecto_final.entities.Ciudad;
import edu.udistrital.acm.proyecto_final.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public ResponseEntity<List<Ciudad>> getAll() {
        return ResponseEntity.ok(ciudadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> getById(@PathVariable Long id) {
        return ciudadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ciudad> create(@RequestBody Ciudad ciudad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(ciudad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Long id, @RequestBody Ciudad ciudad) {
        try {
            return ResponseEntity.ok(ciudadService.update(id, ciudad));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ciudadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<Ciudad>> getByDepartamento(@PathVariable Long departamentoId) {
        return ResponseEntity.ok(ciudadService.findByDepartamento(departamentoId));
    }
}

