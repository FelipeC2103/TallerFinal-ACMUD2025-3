package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Categoria;
import edu.udistrital.acm.proyecto_final.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            Optional<Categoria> existing = categoriaRepository.findById(id);
            if (existing.isPresent()) {
                Categoria updated = existing.get();
                updated.setNombre(categoria.getNombre());
                return categoriaRepository.save(updated);
            }
        }
        throw new RuntimeException("Categoría no encontrada con id: " + id);
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
