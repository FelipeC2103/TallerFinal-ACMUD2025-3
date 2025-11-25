package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Almacen;
import edu.udistrital.acm.proyecto_final.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    // CRUD básico
    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    public Optional<Almacen> findById(Long id) {
        return almacenRepository.findById(id);
    }

    public Almacen save(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    public Almacen update(Long id, Almacen almacen) {
        if (almacenRepository.existsById(id)) {
            Optional<Almacen> existingAlmacen = almacenRepository.findById(id);
            if (existingAlmacen.isPresent()) {
                Almacen updated = existingAlmacen.get();
                updated.setNombre(almacen.getNombre());
                updated.setCiudad(almacen.getCiudad());
                return almacenRepository.save(updated);
            }
        }
        throw new RuntimeException("Almacén no encontrado con id: " + id);
    }

    public void deleteById(Long id) {
        almacenRepository.deleteById(id);
    }

    // Consultas complejas
    public List<Almacen> findByCiudad(Long ciudadId) {
        return almacenRepository.findByCiudad_Id(ciudadId);
    }
}
