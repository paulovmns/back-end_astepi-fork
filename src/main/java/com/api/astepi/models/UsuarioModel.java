package com.api.astepi.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;


@Entity
public class UsuarioModel extends PessoaModel  {
    private static final long serialVersionUID = 1L;

    @Column(length = 10)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;

    @Column(length = 50)
    private String profissao;

    @Column(length = 30)
    private String estadoCivil;

    @Column(length = 30)
    private String nacionalidade;

    @Column(length = 30)
    private String naturalidade;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgendamentoModel> agendamentos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoModel> enderecos = new ArrayList<>();

    public void addAgendamento(AgendamentoModel agendamento) {
        agendamentos.add(agendamento);
        agendamento.setUsuario(this);
    }

    public void removeAgendamento(AgendamentoModel agendamento) {
        agendamentos.remove(agendamento);
        agendamento.setUsuario(null);
    }

    public void addEndereco(EnderecoModel endereco) {
        enderecos.add(endereco);
        endereco.setUsuario(this);
    }

    public void removeEndereco(EnderecoModel endereco) {
        enderecos.remove(endereco);
        endereco.setUsuario(null);
    }

    public List<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<EnderecoModel> getEnderecos() { return enderecos; }

    public void setEnderecos(List<EnderecoModel> enderecos) { this.enderecos = enderecos; }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

}