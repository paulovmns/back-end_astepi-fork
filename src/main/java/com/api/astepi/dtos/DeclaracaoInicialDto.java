package com.api.astepi.dtos;

import javax.validation.constraints.NotBlank;

public class DeclaracaoInicialDto {

    @NotBlank
    private String narrativa;

    @NotBlank
    private boolean parecerVoluntario;

    @NotBlank
    private boolean homologacaoDocente;

    @NotBlank
    DeclaracaoInicialDto declaracaoInicialDto;

    public String getNarrativa() {
        return narrativa;
    }

    public void setNarrativa(String narrativa) {
        this.narrativa = narrativa;
    }

    public boolean isParecerVoluntario() {
        return parecerVoluntario;
    }

    public void setParecerVoluntario(boolean parecerVoluntario) {
        this.parecerVoluntario = parecerVoluntario;
    }

    public boolean isHomologacaoDocente() {
        return homologacaoDocente;
    }

    public void setHomologacaoDocente(boolean homologacaoDocente) {
        this.homologacaoDocente = homologacaoDocente;
    }

    public DeclaracaoInicialDto getDeclaracaoInicialDto() {
        return declaracaoInicialDto;
    }

    public void setDeclaracaoInicialDto(DeclaracaoInicialDto declaracaoInicialDto) {
        this.declaracaoInicialDto = declaracaoInicialDto;
    }
}
