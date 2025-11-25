package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta 5: Listar productos por categoría
    @Query("SELECT p FROM Producto p JOIN ProductoCategoria pc ON p.idProducto = pc.producto.idProducto WHERE pc.categoria.idCategoria = :categoriaId")
    List<Producto> findByCategoria(@Param("categoriaId") Long categoriaId);

    // Consulta 6: Buscar productos por rango de precio
    List<Producto> findByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);

    // Consulta 7: Ordenar productos por precio ascendente/descendente
    List<Producto> findAllByOrderByPrecioAsc();
    List<Producto> findAllByOrderByPrecioDesc();

    // Consulta 8: Listar productos creados después de una fecha
    List<Producto> findByFechaCreacionAfter(LocalDateTime fecha);
}

