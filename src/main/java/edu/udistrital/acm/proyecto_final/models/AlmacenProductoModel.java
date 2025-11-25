package edu.udistrital.acm.proyecto_final.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlmacenProductoModel implements Serializable {
    private Long id;
    private Long idAlmacen;
    private Long productoId;
    private BigInteger stock;
    private String direccion;
}

