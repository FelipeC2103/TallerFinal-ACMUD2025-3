package edu.udistrital.acm.proyecto_final.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenModel implements Serializable {

    private Long idAlmacen;
    private String nombreAlmacen;
    private CiudadModel ciudadAlmacen;



}
