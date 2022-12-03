package com.api.astepi.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PessoaDto {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nome;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Size (max = 11)
    private String cpf;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int celular;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String email;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int matricula;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cargo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private boolean status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nomeLogin;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
