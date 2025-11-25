package edu.udistrital.acm.proyecto_final.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaModel {
    private Long idVenta;
    private UsuarioModel idUsuario;
}
