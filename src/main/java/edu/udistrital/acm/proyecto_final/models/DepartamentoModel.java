package edu.udistrital.acm.proyecto_final.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoModel  implements Serializable {

    private Long idDepartamento;
    private String nombre;
}
