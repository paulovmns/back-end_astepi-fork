package com.api.astepi.dtos;

import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.models.UsuarioModel;

import javax.validation.constraints.NotBlank;

public class DeclaracaoInicialDto {

    @NotBlank
    private String narrativa;

    @NotBlank
    private long id;

    @NotBlank
    private boolean parecerVoluntario;


    public String getNarrativa() {
        return narrativa;
    }

    public void setNarrativa(String narrativa) {
        this.narrativa = narrativa;
    }

    public boolean getParecerVoluntario() {
        return parecerVoluntario;
    }

    public void setParecerVoluntario(boolean parecerVoluntario) {
        this.parecerVoluntario = parecerVoluntario;
    }

    public long getId() {  return id;    }

    public long setId(long id) {  this.id = id;}



}
