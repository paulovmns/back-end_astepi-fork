package com.api.astepi.dtos;

import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.models.UsuarioModel;

import javax.validation.constraints.NotBlank;

public class DocumentoDto {

    @NotBlank
    private String nome;

    @NotBlank
    UsuarioModel usuarioModel;

    @NotBlank
    AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public AdvogadoVoluntarioModel getAdvogadoVoluntarioModel() {
        return advogadoVoluntarioModel;
    }

    public void setAdvogadoVoluntarioModel(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        this.advogadoVoluntarioModel = advogadoVoluntarioModel;
    }
}
