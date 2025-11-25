package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Ciudad;
import edu.udistrital.acm.proyecto_final.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public Ciudad update(Long id, Ciudad ciudad) {
        if (ciudadRepository.existsById(id)) {
            Optional<Ciudad> existing = ciudadRepository.findById(id);
            if (existing.isPresent()) {
                Ciudad updated = existing.get();
                updated.setNombre(ciudad.getNombre());
                updated.setDepartamento(ciudad.getDepartamento());
                return ciudadRepository.save(updated);
            }
        }
        throw new RuntimeException("Ciudad no encontrada con id: " + id);
    }

    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }

    public List<Ciudad> findByDepartamento(Long departamentoId) {
        return ciudadRepository.findByDepartamento_IdDepartamento(departamentoId);
    }
}
