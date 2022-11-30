package com.api.astepi.dtos;

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
