package com.api.astepi.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class SecretarioDto {

    @NotBlank
    UsuarioDto usuarioDto;

    @NotBlank
    SecretariaDto secretariaDto;

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public SecretariaDto getSecretariaDto() {
        return secretariaDto;
    }

    public void setSecretariaDto(SecretariaDto secretariaDto) {
        this.secretariaDto = secretariaDto;
    }
}
