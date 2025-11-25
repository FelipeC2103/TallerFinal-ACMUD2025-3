package edu.udistrital.acm.proyecto_final.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadModel implements Serializable {
    private Long idCiudad;
    private DepartamentoModel idDepartamento;
    private String nombreCiudad;
}

