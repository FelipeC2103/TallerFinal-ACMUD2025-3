package edu.udistrital.acm.proyecto_final.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel implements Serializable {
    private Long id;


    private String nombre;
    private String apellido;
    private String ussername;
    private String password;
    private String email;
    private LocalDateTime fechaRegistro;
    private String telefono;

    private RolUsuarioModel rol;

    private CiudadModel ciudad;
}

