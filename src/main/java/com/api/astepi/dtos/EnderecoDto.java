package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class EnderecoDto {


    @JsonIgnoreProperties(ignoreUnknown = true)
    private UUID usuarioId;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String rua;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String numero;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cep;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String complemento;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String referencia;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String bairro;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cidade;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String estado;

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
