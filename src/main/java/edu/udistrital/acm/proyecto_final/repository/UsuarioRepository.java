package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta 1: Buscar usuarios por apellido
    List<Usuario> findByApellido(String apellido);

    // Consulta 2: Listar usuarios de una ciudad específica
    List<Usuario> findByCiudad_Id(Long ciudadId);

    // Consulta 3: Listar usuarios por departamento
    @Query("SELECT u FROM Usuario u WHERE u.ciudad.departamento.idDepartamento = :departamentoId")
    List<Usuario> findByDepartamento(@Param("departamentoId") Long departamentoId);

    // Consulta 4: Buscar usuarios cuyo nombre contenga X texto
    List<Usuario> findByNombreContaining(String texto);
}

