package com.api.astepi.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdvogadoVoluntarioDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String numOAB;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String formacaoAcad;

    public String getNumOAB() {
        return numOAB;
    }

    public void setNumOAB(String numOAB) {
        this.numOAB = numOAB;
    }

    public String getFormacaoAcad() {
        return formacaoAcad;
    }

    public void setFormacaoAcad(String formacaoAcad) {
        this.formacaoAcad = formacaoAcad;
    }

}
