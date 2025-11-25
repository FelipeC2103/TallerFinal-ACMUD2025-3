package edu.udistrital.acm.proyecto_final.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @ManyToOne
    @JoinColumn(name = "idRolFK")
    private RolUsuario rolUsuario;

    @ManyToOne
    @JoinColumn(name = "idCiudadFK")
    private Ciudad ciudad;

    private String nombre;
    private String apellido;

    @Column(nullable = false, unique = true)
    private String usSername;

    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime fechaRegistro;

    private String telefono;
}
