package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.AlmacenProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlmacenProductoRepository extends JpaRepository<AlmacenProducto, Long> {

    // Consulta 9: Listar todos los productos de un almacén
    List<AlmacenProducto> findByAlmacen_IdAlmacen(Long almacenId);

    @Query("SELECT ap FROM AlmacenProducto ap WHERE ap.almacen.idAlmacen = :almacenId")
    List<AlmacenProducto> findProductosByAlmacen(@Param("almacenId") Long almacenId);
}

