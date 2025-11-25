package edu.udistrital.acm.proyecto_final.services;

import edu.udistrital.acm.proyecto_final.entities.Usuario;
import edu.udistrital.acm.proyecto_final.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // CRUD básico
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            Optional<Usuario> existing = usuarioRepository.findById(id);
            if (existing.isPresent()) {
                Usuario updated = existing.get();
                if (usuario.getNombre() != null) {
                    updated.setNombre(usuario.getNombre());
                }
                if (usuario.getApellido() != null) {
                    updated.setApellido(usuario.getApellido());
                }
                if (usuario.getUsSername() != null) {
                    updated.setUsSername(usuario.getUsSername());
                }
                if (usuario.getPassword() != null) {
                    updated.setPassword(usuario.getPassword());
                }
                if (usuario.getEmail() != null) {
                    updated.setEmail(usuario.getEmail());
                }
                if (usuario.getTelefono() != null) {
                    updated.setTelefono(usuario.getTelefono());
                }
                if (usuario.getRolUsuario() != null) {
                    updated.setRolUsuario(usuario.getRolUsuario());
                }
                if (usuario.getCiudad() != null) {
                    updated.setCiudad(usuario.getCiudad());
                }
                return usuarioRepository.save(updated);
            }
        }
        throw new RuntimeException("Usuario no encontrado con id: " + id);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Consultas complejas
    public List<Usuario> findByApellido(String apellido) {
        return usuarioRepository.findByApellido(apellido);
    }

    public List<Usuario> findByCiudad(Long ciudadId) {
        return usuarioRepository.findByCiudad_Id(ciudadId);
    }

    public List<Usuario> findByDepartamento(Long departamentoId) {
        return usuarioRepository.findByDepartamento(departamentoId);
    }

    public List<Usuario> findByNombreContaining(String texto) {
        return usuarioRepository.findByNombreContaining(texto);
    }
}
