package edu.udistrital.acm.proyecto_final.controller;

import edu.udistrital.acm.proyecto_final.entities.Usuario;
import edu.udistrital.acm.proyecto_final.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CRUD básico
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(usuarioService.update(id, usuario));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consultas complejas
    // Consulta 1: Buscar usuarios por apellido
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<Usuario>> getByApellido(@PathVariable String apellido) {
        return ResponseEntity.ok(usuarioService.findByApellido(apellido));
    }

    // Consulta 2: Listar usuarios de una ciudad específica
    @GetMapping("/ciudad/{ciudadId}")
    public ResponseEntity<List<Usuario>> getByCiudad(@PathVariable Long ciudadId) {
        return ResponseEntity.ok(usuarioService.findByCiudad(ciudadId));
    }

    // Consulta 3: Listar usuarios por departamento
    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<Usuario>> getByDepartamento(@PathVariable Long departamentoId) {
        return ResponseEntity.ok(usuarioService.findByDepartamento(departamentoId));
    }

    // Consulta 4: Buscar usuarios cuyo nombre contenga X texto
    @GetMapping("/nombre/buscar")
    public ResponseEntity<List<Usuario>> getByNombreContaining(@RequestParam String texto) {
        return ResponseEntity.ok(usuarioService.findByNombreContaining(texto));
    }
}

