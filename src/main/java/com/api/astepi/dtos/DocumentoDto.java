package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

public class DocumentoDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nomeDoc;

    public String getNomeDoc() {
        return nomeDoc;
    }

    public void setNomeDoc(String nomeDoc) {
        this.nomeDoc = nomeDoc;
    }
}
