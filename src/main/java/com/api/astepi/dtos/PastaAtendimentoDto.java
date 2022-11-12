package com.api.astepi.dtos;

import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.models.SecretariaModel;

import javax.validation.constraints.NotBlank;

public class PastaAtendimentoDto {

    @NotBlank
    SecretariaDto secretariaDto;

    @NotBlank
    AdvogadoVoluntarioDto advogadoVoluntarioDto;

    public SecretariaDto getSecretariaDto() {
        return secretariaDto;
    }

    public void setSecretariaDto(SecretariaDto secretariaDto) {
        this.secretariaDto = secretariaDto;
    }

    public AdvogadoVoluntarioDto getAdvogadoVoluntarioDto() {
        return advogadoVoluntarioDto;
    }

    public void setAdvogadoVoluntarioDto(AdvogadoVoluntarioDto advogadoVoluntarioDto) {
        this.advogadoVoluntarioDto = advogadoVoluntarioDto;
    }
}
