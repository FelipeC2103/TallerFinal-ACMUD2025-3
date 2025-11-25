package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.AlmacenProducto;
import edu.udistrital.acm.proyecto_final.repository.AlmacenProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenProductoService {

    @Autowired
    private AlmacenProductoRepository almacenProductoRepository;

    // CRUD básico
    public List<AlmacenProducto> findAll() {
        return almacenProductoRepository.findAll();
    }

    public Optional<AlmacenProducto> findById(Long id) {
        return almacenProductoRepository.findById(id);
    }

    public AlmacenProducto save(AlmacenProducto almacenProducto) {
        return almacenProductoRepository.save(almacenProducto);
    }

    public AlmacenProducto update(Long id, AlmacenProducto almacenProducto) {
        if (almacenProductoRepository.existsById(id)) {
            Optional<AlmacenProducto> existing = almacenProductoRepository.findById(id);
            if (existing.isPresent()) {
                AlmacenProducto updated = existing.get();
                updated.setAlmacen(almacenProducto.getAlmacen());
                updated.setProducto(almacenProducto.getProducto());
                updated.setStock(almacenProducto.getStock());
                updated.setDireccion(almacenProducto.getDireccion());
                return almacenProductoRepository.save(updated);
            }
        }
        throw new RuntimeException("AlmacenProducto no encontrado con id: " + id);
    }

    public void deleteById(Long id) {
        almacenProductoRepository.deleteById(id);
    }

    // Consultas complejas
    public List<AlmacenProducto> findProductosByAlmacen(Long almacenId) {
        return almacenProductoRepository.findProductosByAlmacen(almacenId);
    }
}
