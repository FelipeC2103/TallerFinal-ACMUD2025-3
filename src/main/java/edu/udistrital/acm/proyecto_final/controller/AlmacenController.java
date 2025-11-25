package edu.udistrital.acm.proyecto_final.controller;

import edu.udistrital.acm.proyecto_final.entities.Almacen;
import edu.udistrital.acm.proyecto_final.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @GetMapping
    public ResponseEntity<List<Almacen>> getAll() {
        return ResponseEntity.ok(almacenService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getById(@PathVariable Long id) {
        return almacenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Almacen> create(@RequestBody Almacen almacen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(almacenService.save(almacen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> update(@PathVariable Long id, @RequestBody Almacen almacen) {
        try {
            return ResponseEntity.ok(almacenService.update(id, almacen));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        almacenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 10: Listar almacenes de una ciudad
    @GetMapping("/ciudad/{ciudadId}")
    public ResponseEntity<List<Almacen>> getByCiudad(@PathVariable Long ciudadId) {
        return ResponseEntity.ok(almacenService.findByCiudad(ciudadId));
    }
}

