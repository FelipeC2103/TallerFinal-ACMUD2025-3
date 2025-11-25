package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    // Consulta 11: Listar ventas por usuario cliente
    List<Venta> findByCliente_Id(Long clienteId);

    // Consulta 12: Consultar total vendido por fecha
    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fechaVenta BETWEEN :fechaInicio AND :fechaFin")
    BigInteger getTotalVendidoPorFecha(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    List<Venta> findByFechaVentaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Consulta 13: Buscar ventas con monto mayor a X valor
    List<Venta> findByTotalGreaterThan(BigInteger monto);
}

