package com.api.astepi.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PessoaDto {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nome;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cpf;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String rg;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String celular;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String telFixo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String email;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String matricula;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cargo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String username;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String password;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private LocalDateTime registrationDate;

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
