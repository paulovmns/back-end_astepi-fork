package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class EnderecoDto {


    @JsonIgnoreProperties(ignoreUnknown = true)
    private UUID usuarioId;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String rua;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int numero;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cep;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String complemento;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int celular;

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
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
