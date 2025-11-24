package edu.udistrital.acm.proyecto_final.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCategoriaModel implements Serializable {
    private Long id;
    private ProductoModel idProducto;
    private CategoriaModel idCategoria;
}

