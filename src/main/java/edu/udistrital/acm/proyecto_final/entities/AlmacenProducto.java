package edu.udistrital.acm.proyecto_final.entities;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AlmacenProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idAlmacenFK")
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "idProductoFK")
    private Producto producto;

    private BigInteger stock;
    private String direccion;
}
