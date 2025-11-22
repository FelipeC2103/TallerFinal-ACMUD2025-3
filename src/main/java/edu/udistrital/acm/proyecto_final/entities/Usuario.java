package edu.udistrital.acm.proyecto_final.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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
    private String ussername;

    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime fechaRegistro;

    private String telefono;
}
