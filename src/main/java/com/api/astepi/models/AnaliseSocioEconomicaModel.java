package com.api.astepi.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_ANALISESOCIOECO")
public class AnaliseSocioEconomicaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 2)
    private int numeroDependentes;

    @Column(length = 2)
    private int qtdDesempregados;

    @Column(length = 20)
    private double rendaFamiliar;

    @Column(length = 20)
    private double rendaPerCapita;

    @Column(length = 254)
    private String nomePai;

    @Column(length = 254)
    private String nomeMae;

    @Column(length = 254)
    private String profissaoCompanheiro;

    @Column(length = 20)
    private double despesaAluguel;

    @Column(length = 20)
    private double despesaColegio;

    @Column(length = 20)
    private double outrasDespesas;

    @Column(length = 254)
    private String tipoAtendimento;

    @Column(length = 254)
    private String portaDeEntrada;

    @Column(columnDefinition="text", length=10485760)
    private String observacao;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    //@Column(nullable = false, unique = true, length = 255)
    //AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
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

    public double rendaPerCapita() {
        return (this.rendaFamiliar/this.numeroDependentes);
    }

}
