package edu.udistrital.acm.proyecto_final.enums;

import  lombok.Getter;

@Getter
public enum RolUsuarioEnum {
    ADMIN("ADMIN"),
    USER("USER"),
    MANAGER("MANAGER");

    private String rol;

    RolUsuarioEnum(String rol) {
        this.rol = rol;
    }
}
