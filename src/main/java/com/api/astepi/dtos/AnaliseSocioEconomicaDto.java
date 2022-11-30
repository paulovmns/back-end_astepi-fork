package com.api.astepi.dtos;


import com.api.astepi.models.AdvogadoVoluntarioModel;

import javax.validation.constraints.NotBlank;

public class AnaliseSocioEconomicaDto {

    @NotBlank
    private int numeroDependentes;

    @NotBlank
    private int qtdDesempregados;

    @NotBlank
    private double rendaFamiliar;

    @NotBlank
    private String nomePai;

    @NotBlank
    private String nomeMae;

    @NotBlank
    private String profissaoCompanheiro;

    @NotBlank
    private double despesaAluguel;

    @NotBlank
    private double despesaColegio;

    @NotBlank
    private double outrasDespesas;

    @NotBlank
    private boolean tipoAtendimento;

    @NotBlank
    private boolean portaDeEntrada;

    @NotBlank
    UsuarioDto usuarioDto;

    @NotBlank
    AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    public int getQtdDesempregados() {
        return qtdDesempregados;
    }

    public void setQtdDesempregados(int qtdDesempregados) {
        this.qtdDesempregados = qtdDesempregados;
    }

    public double getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(double rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getProfissaoCompanheiro() {
        return profissaoCompanheiro;
    }

    public void setProfissaoCompanheiro(String profissaoCompanheiro) {
        this.profissaoCompanheiro = profissaoCompanheiro;
    }

    public double getDespesaAluguel() {
        return despesaAluguel;
    }

    public void setDespesaAluguel(double despesaAluguel) {
        this.despesaAluguel = despesaAluguel;
    }

    public double getDespesaColegio() {
        return despesaColegio;
    }

    public void setDespesaColegio(double despesaColegio) {
        this.despesaColegio = despesaColegio;
    }

    public double getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(double outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    public boolean isTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(boolean tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public boolean isPortaDeEntrada() {
        return portaDeEntrada;
    }

    public void setPortaDeEntrada(boolean portaDeEntrada) {
        this.portaDeEntrada = portaDeEntrada;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public AdvogadoVoluntarioModel getAdvogadoVoluntarioModel() {
        return advogadoVoluntarioModel;
    }

    public void setAdvogadoVoluntarioModel(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        this.advogadoVoluntarioModel = advogadoVoluntarioModel;
    }
}
