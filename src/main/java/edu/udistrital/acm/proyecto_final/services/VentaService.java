package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Venta;
import edu.udistrital.acm.proyecto_final.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // CRUD básico
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> findById(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta save(Venta venta) {
        if (venta.getFechaVenta() == null) {
            venta.setFechaVenta(LocalDateTime.now());
        }
        return ventaRepository.save(venta);
    }

    public Venta update(Long id, Venta venta) {
        if (ventaRepository.existsById(id)) {
            Optional<Venta> existing = ventaRepository.findById(id);
            if (existing.isPresent()) {
                Venta updated = existing.get();
                updated.setCliente(venta.getCliente());
                updated.setTotal(venta.getTotal());
                if (venta.getFechaVenta() != null) {
                    updated.setFechaVenta(venta.getFechaVenta());
                }
                return ventaRepository.save(updated);
            }
        }
        throw new RuntimeException("Venta no encontrada con id: " + id);
    }

    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }

    // Consultas complejas
    public List<Venta> findByCliente(Long clienteId) {
        return ventaRepository.findByCliente_Id(clienteId);
    }

    public BigInteger getTotalVendidoPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return ventaRepository.getTotalVendidoPorFecha(fechaInicio, fechaFin);
    }

    public List<Venta> findByFechaVenta(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return ventaRepository.findByFechaVentaBetween(fechaInicio, fechaFin);
    }

    public List<Venta> findByMontoMayorA(BigInteger monto) {
        return ventaRepository.findByTotalGreaterThan(monto);
    }
}
