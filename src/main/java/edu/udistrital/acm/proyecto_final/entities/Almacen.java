package edu.udistrital.acm.proyecto_final.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlmacen;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idCiudadFK")
    private Ciudad ciudad;
}
