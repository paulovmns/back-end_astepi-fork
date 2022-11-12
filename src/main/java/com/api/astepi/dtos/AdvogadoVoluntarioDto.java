package com.api.astepi.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdvogadoVoluntarioDto {

    @NotBlank
    private String numOAB;

    @NotBlank
    private long id;

    @NotBlank
    private String formacaoAcad;


    public String getNumOAB() {
        return numOAB;
    }

    public void setNumOAB(String numOAB) {
        this.numOAB = numOAB;
    }

    public long getId() {
        return id;
    }

    public long setId(String id) {
        this.id = id;
    }

    public int getformacaoAcad() {
        return formacaoAcad;
    }

    public void setFormacaoAcad(int formacaoAcad) {
        this.formacaoAcad = formacaoAcad;
    }

}
