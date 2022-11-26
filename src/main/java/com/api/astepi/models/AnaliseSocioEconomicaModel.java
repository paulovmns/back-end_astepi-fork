package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_ANALISESEC")
public class AnaliseSocioEconomicaModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 15)
    private int numeroDependentes;

    @Column(nullable = false, length = 15)
    private int qtdDesempregados;

    @Column(nullable = false, length = 20)
    private double rendaFamiliar;

    @Column(nullable = false, unique = true, length = 255)
    private String nomePai;

    @Column(nullable = false, unique = true, length = 255)
    private String nomeMae;

    @Column(nullable = false, unique = true, length = 255)
    private String profissaoCompanheiro;

    @Column(nullable = false, length = 20)
    private double despesaAluguel;

    @Column(nullable = false, length = 20)
    private double despesaColegio;

    @Column(nullable = false, length = 20)
    private double outrasDespesas;

    @Column(nullable = false, length = 10)
    private boolean tipoAtendimento;

    @Column(nullable = false, length = 10)
    private boolean portaDeEntrada;

    @Column(nullable = false, unique = true, length = 255)
    UsuarioModel usuarioModel;

    @Column(nullable = false, unique = true, length = 255)
    AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public AdvogadoVoluntarioModel getAdvogadoVoluntarioModel() {
        return advogadoVoluntarioModel;
    }

    public void setAdvogadoVoluntarioModel(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        this.advogadoVoluntarioModel = advogadoVoluntarioModel;
    }

    public double rendaPerCapita() {
        return (this.rendaFamiliar/this.numeroDependentes);
    }

}
