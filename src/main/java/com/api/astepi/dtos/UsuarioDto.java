package com.api.astepi.dtos;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UsuarioDto {
    @NotBlank
    private Date dataNascimento;

    @NotBlank
    private String profissao;

    @NotBlank
    private boolean estadoCivil;

    @NotBlank
    private String nacionalidade;

    @NotBlank
    private String naturalidade;

    @NotBlank
    //FormularioDto formularioDto;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public boolean isEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

   // public FormularioDto getFormularioDto() {
       // return formularioDto;
    //}

   // public void setFormularioDto(FormularioDto formularioDto) {
        //this.formularioDto = formularioDto;
    //}
}
