package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long> {

    // Consulta 10: Listar almacenes de una ciudad
    List<Almacen> findByCiudad_Id(Long ciudadId);
}

