package edu.udistrital.acm.proyecto_final.controller;

import edu.udistrital.acm.proyecto_final.entities.Venta;
import edu.udistrital.acm.proyecto_final.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAll() {
        return ResponseEntity.ok(ventaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getById(@PathVariable Long id) {
        return ventaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venta> create(@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> update(@PathVariable Long id, @RequestBody Venta venta) {
        try {
            return ResponseEntity.ok(ventaService.update(id, venta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consultas complejas
    // Consulta 11: Listar ventas por usuario cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Venta>> getByCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(ventaService.findByCliente(clienteId));
    }

    // Consulta 12: Consultar total vendido por fecha
    @GetMapping("/total/fecha")
    public ResponseEntity<BigInteger> getTotalVendidoPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        BigInteger total = ventaService.getTotalVendidoPorFecha(fechaInicio, fechaFin);
        return ResponseEntity.ok(total != null ? total : BigInteger.ZERO);
    }

    @GetMapping("/fecha/rango")
    public ResponseEntity<List<Venta>> getByFechaVenta(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        return ResponseEntity.ok(ventaService.findByFechaVenta(fechaInicio, fechaFin));
    }

    // Consulta 13: Buscar ventas con monto mayor a X valor
    @GetMapping("/monto/mayor")
    public ResponseEntity<List<Venta>> getByMontoMayorA(@RequestParam BigInteger monto) {
        return ResponseEntity.ok(ventaService.findByMontoMayorA(monto));
    }
}

