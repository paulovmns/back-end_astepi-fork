package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AdministradorDto {


    @JsonIgnoreProperties(ignoreUnknown = true)
    private String sistema;




    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
}
