package edu.udistrital.acm.proyecto_final.controller;

import edu.udistrital.acm.proyecto_final.entities.Producto;
import edu.udistrital.acm.proyecto_final.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // CRUD básico
    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            return ResponseEntity.ok(productoService.update(id, producto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consultas complejas
    // Consulta 5: Listar productos por categoría
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Producto>> getByCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(productoService.findByCategoria(categoriaId));
    }

    // Consulta 6: Buscar productos por rango de precio
    @GetMapping("/precio/rango")
    public ResponseEntity<List<Producto>> getByRangoPrecio(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return ResponseEntity.ok(productoService.findByRangoPrecio(min, max));
    }

    // Consulta 7: Ordenar productos por precio
    @GetMapping("/precio/ordenar")
    public ResponseEntity<List<Producto>> getOrdenadosPorPrecio(@RequestParam(defaultValue = "asc") String orden) {
        if ("desc".equalsIgnoreCase(orden)) {
            return ResponseEntity.ok(productoService.findAllOrderByPrecioDesc());
        }
        return ResponseEntity.ok(productoService.findAllOrderByPrecioAsc());
    }

    // Consulta 8: Listar productos creados después de una fecha
    @GetMapping("/fecha/despues")
    public ResponseEntity<List<Producto>> getCreadosDespuesDeFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        return ResponseEntity.ok(productoService.findCreadosDespuesDeFecha(fecha));
    }
}

