package com.api.astepi.dtos;


import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnaliseSocioEconomicaDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int numeroDependentes;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int qtdDesempregados;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private double rendaFamiliar;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private double rendaPerCapita;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nomePai;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nomeMae;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String profissaoCompanheiro;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private double despesaAluguel;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private double despesaColegio;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private double outrasDespesas;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String tipoAtendimento;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String portaDeEntrada;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String observacao;


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

    public double getRendaPerCapita() {
        return rendaPerCapita;
    }

    public void setRendaPerCapita(double rendaPerCapita) {
        this.rendaPerCapita = rendaPerCapita;
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

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getPortaDeEntrada() {
        return portaDeEntrada;
    }

    public void setPortaDeEntrada(String portaDeEntrada) {
        this.portaDeEntrada = portaDeEntrada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
