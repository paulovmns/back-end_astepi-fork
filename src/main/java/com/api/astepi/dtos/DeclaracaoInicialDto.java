package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

public class DeclaracaoInicialDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String narrativa;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String parecerVoluntario;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String homologacaoDocente;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String homologacaoComentario;

    public String getNarrativa() {
        return narrativa;
    }

    public void setNarrativa(String narrativa) {
        this.narrativa = narrativa;
    }

    public String getParecerVoluntario() {
        return parecerVoluntario;
    }

    public void setParecerVoluntario(String parecerVoluntario) {
        this.parecerVoluntario = parecerVoluntario;
    }

    public String isHomologacaoDocente() {
        return homologacaoDocente;
    }

    public void setHomologacaoDocente(String homologacaoDocente) {
        this.homologacaoDocente = homologacaoDocente;
    }

    public String getHomologacaoComentario() {
        return homologacaoComentario;
    }

    public void setHomologacaoComentario(String homologacaoComentario) {
        this.homologacaoComentario = homologacaoComentario;
    }
}
