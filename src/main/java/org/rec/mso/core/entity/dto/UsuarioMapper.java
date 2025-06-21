package org.rec.mso.core.entity.dto;

import org.rec.mso.core.entity.dominio.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setRol(usuario.getRol());
        dto.setEstado(usuario.getEstado());
        dto.setIntento(usuario.getIntento());
        dto.setContrasenia(usuario.getContrasenia());
        dto.setPersona(usuario.getPersona());
        return dto;
    }

    public static List<UsuarioDto> toDtoList(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}
