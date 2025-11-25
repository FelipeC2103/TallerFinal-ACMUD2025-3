package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {
}
