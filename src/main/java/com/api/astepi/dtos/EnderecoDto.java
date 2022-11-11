package com.api.astepi.dtos;

import com.api.astepi.models.UsuarioModel;

import javax.validation.constraints.NotBlank;

public class EnderecoDto {

    @NotBlank
    private String rua;

    @NotBlank
    private int numero;

    @NotBlank
    private String cep;

    @NotBlank
    private String complemento;

    @NotBlank
    private int telefoneFixo;

    @NotBlank
    private int celular;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    UsuarioModel usuarioModel;

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

    public int getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(int telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
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

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
}
