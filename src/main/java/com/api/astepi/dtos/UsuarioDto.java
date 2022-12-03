package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class UsuarioDto {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String profissao;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String estadoCivil;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nacionalidade;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String naturalidade;

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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
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
}
