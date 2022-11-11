package com.api.astepi.dtos;

import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.models.SecretariaModel;

import javax.validation.constraints.NotBlank;

public class PastaAtendimentoDto {

    @NotBlank
    SecretariaModel secretariaModel;

    @NotBlank
    AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public SecretariaModel getSecretariaModel() {
        return secretariaModel;
    }

    public void setSecretariaModel(SecretariaModel secretariaModel) {
        this.secretariaModel = secretariaModel;
    }

    public AdvogadoVoluntarioModel getAdvogadoVoluntarioModel() {
        return advogadoVoluntarioModel;
    }

    public void setAdvogadoVoluntarioModel(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        this.advogadoVoluntarioModel = advogadoVoluntarioModel;
    }
}
