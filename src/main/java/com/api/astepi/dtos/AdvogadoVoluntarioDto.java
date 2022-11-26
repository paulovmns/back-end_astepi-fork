package com.api.astepi.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdvogadoVoluntarioDto {

    @NotBlank
    private String numOAB;

    @NotBlank
    private String formacaoAcad;

    @NotBlank
    UsuarioDto usuarioDto;

    public String getNumOAB() {
        return numOAB;
    }

    public void setNumOAB(String numOAB) {
        this.numOAB = numOAB;
    }

    public String getFormacaoAcad() {
        return formacaoAcad;
    }

    public void setFormacaoAcad(String formacaoAcad) {
        this.formacaoAcad = formacaoAcad;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}
