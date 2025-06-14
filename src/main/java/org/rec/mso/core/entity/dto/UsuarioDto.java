package org.rec.mso.core.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.rec.mso.core.entity.models.Persona;

@Getter
@Setter
public class UsuarioDto {
    private Integer id;

    private String contrasenia;

    private String estado;

    private Integer intento;

    private String rol;

    private String username;

    private Persona persona;
}
