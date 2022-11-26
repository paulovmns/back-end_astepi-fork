package com.api.astepi.dtos;

import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.models.UsuarioModel;

import javax.validation.constraints.NotBlank;

public class SecretariaDto {

    @NotBlank
    FormularioDto formularioDto;

    public FormularioDto getFormularioDto() {
        return formularioDto;
    }

    public void setFormularioDto(FormularioDto formularioDto) {
        this.formularioDto = formularioDto;
    }
}
