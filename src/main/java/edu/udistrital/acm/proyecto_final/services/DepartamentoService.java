package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Departamento;
import edu.udistrital.acm.proyecto_final.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento update(Long id, Departamento departamento) {
        if (departamentoRepository.existsById(id)) {
            Optional<Departamento> existing = departamentoRepository.findById(id);
            if (existing.isPresent()) {
                Departamento updated = existing.get();
                updated.setNombre(departamento.getNombre());
                return departamentoRepository.save(updated);
            }
        }
        throw new RuntimeException("Departamento no encontrado con id: " + id);
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }
}
