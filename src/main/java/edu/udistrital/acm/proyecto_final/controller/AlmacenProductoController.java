package edu.udistrital.acm.proyecto_final.controller;

import edu.udistrital.acm.proyecto_final.entities.AlmacenProducto;
import edu.udistrital.acm.proyecto_final.services.AlmacenProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacen-productos")
public class AlmacenProductoController {

    @Autowired
    private AlmacenProductoService almacenProductoService;

    @GetMapping
    public ResponseEntity<List<AlmacenProducto>> getAll() {
        return ResponseEntity.ok(almacenProductoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlmacenProducto> getById(@PathVariable Long id) {
        return almacenProductoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlmacenProducto> create(@RequestBody AlmacenProducto almacenProducto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(almacenProductoService.save(almacenProducto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlmacenProducto> update(@PathVariable Long id, @RequestBody AlmacenProducto almacenProducto) {
        try {
            return ResponseEntity.ok(almacenProductoService.update(id, almacenProducto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        almacenProductoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 9: Listar todos los productos de un almacén
    @GetMapping("/almacen/{almacenId}")
    public ResponseEntity<List<AlmacenProducto>> getProductosByAlmacen(@PathVariable Long almacenId) {
        return ResponseEntity.ok(almacenProductoService.findProductosByAlmacen(almacenId));
    }
}

