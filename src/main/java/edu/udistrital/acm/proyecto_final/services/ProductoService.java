package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Producto;
import edu.udistrital.acm.proyecto_final.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // CRUD básico
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        if (producto.getFechaCreacion() == null) {
            producto.setFechaCreacion(LocalDateTime.now());
        }
        producto.setFechaActualizacion(LocalDateTime.now());
        return productoRepository.save(producto);
    }

    public Producto update(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            Optional<Producto> existing = productoRepository.findById(id);
            if (existing.isPresent()) {
                Producto updated = existing.get();
                updated.setNombre(producto.getNombre());
                updated.setDescripcion(producto.getDescripcion());
                updated.setPrecio(producto.getPrecio());
                updated.setFechaActualizacion(LocalDateTime.now());
                return productoRepository.save(updated);
            }
        }
        throw new RuntimeException("Producto no encontrado con id: " + id);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    // Consultas complejas
    public List<Producto> findByCategoria(Long categoriaId) {
        return productoRepository.findByCategoria(categoriaId);
    }

    public List<Producto> findByRangoPrecio(BigDecimal precioMin, BigDecimal precioMax) {
        return productoRepository.findByPrecioBetween(precioMin, precioMax);
    }

    public List<Producto> findAllOrderByPrecioAsc() {
        return productoRepository.findAllByOrderByPrecioAsc();
    }

    public List<Producto> findAllOrderByPrecioDesc() {
        return productoRepository.findAllByOrderByPrecioDesc();
    }

    public List<Producto> findCreadosDespuesDeFecha(LocalDateTime fecha) {
        return productoRepository.findByFechaCreacionAfter(fecha);
    }
}
