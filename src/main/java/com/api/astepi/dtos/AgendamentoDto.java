package com.api.astepi.dtos;


import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.models.UsuarioModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AgendamentoDto {

    @NotBlank
    private int dia;

    @NotBlank
    private int mes;

    @NotBlank
    private int ano;

    @NotBlank
    private int horario;

    @NotBlank
    private String sala;

    @NotBlank
    UsuarioDto usuarioDto;

    @NotBlank
    SecretariaDto secretariaDto;

    @NotBlank
    EnderecoDto enderecoDto;

    @NotBlank
    DocumentoDto documentoDto;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

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
    }
}
