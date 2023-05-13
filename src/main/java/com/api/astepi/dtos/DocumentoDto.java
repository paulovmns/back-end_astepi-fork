package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class DocumentoDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nome;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String tipo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Long tamanho;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private byte[] arquivo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private LocalDateTime dataEnvio;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
