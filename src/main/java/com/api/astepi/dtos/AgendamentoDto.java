package com.api.astepi.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AgendamentoDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private UUID usuarioId;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String dia;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String mes;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String ano;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String horario;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String observacao;


    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    /*
    @JsonIgnoreProperties(ignoreUnknown = true)
    UsuarioDto usuarioDto;
    @JsonIgnoreProperties(ignoreUnknown = true)
    SecretariaDto secretariaDto;
    @JsonIgnoreProperties(ignoreUnknown = true)
    EnderecoDto enderecoDto;
    @JsonIgnoreProperties(ignoreUnknown = true)
    DocumentoDto documentoDto;*/

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /*
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
    public EnderecoDto getEnderecoDto() {
        return enderecoDto;
    }
    public void setEnderecoDto(EnderecoDto enderecoDto) {
        this.enderecoDto = enderecoDto;
    }
    public DocumentoDto getDocumentoDto() {
        return documentoDto;
    }
    public void setDocumentoDto(DocumentoDto documentoDto) {
        this.documentoDto = documentoDto;
    }*/
}