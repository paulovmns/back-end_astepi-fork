package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

public class DocumentoDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nome;

  /* @NotBlank
    UsuarioDto usuarioDto;

    @NotBlank
    AdvogadoVoluntarioDto advogadoVoluntarioDto;*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   // public UsuarioDto getUsuarioDto() {
        //return usuarioDto;
   // }

    //public void setUsuarioDto(UsuarioDto usuarioDto) {
        //this.usuarioDto = usuarioDto;
  //  }

   // public AdvogadoVoluntarioDto getAdvogadoVoluntarioDto()
        //return advogadoVoluntarioDto;
   // }

    //public void setAdvogadoVoluntarioDto(AdvogadoVoluntarioDto advogadoVoluntarioDto) {
       // this.advogadoVoluntarioDto = advogadoVoluntarioDto;
    //}
}
