package com.api.astepi.dtos;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class AdministradorDto {

    @NotBlank
    UsuarioDto usuarioDto;

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}
