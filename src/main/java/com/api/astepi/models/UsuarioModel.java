package com.api.astepi.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UsuarioModel extends PessoaModel  {
    private static final long serialVersionUID = 11;


    @Column(nullable = true, unique = true, length = 10)
    private Date dataNascimento;

    @Column(nullable = true, unique = true, length = 50)
    private String profissao;

    @Column(nullable = true, unique = true, length =25)
    private boolean estadoCivil;

    @Column(nullable = true, unique = true, length = 25)
    private String nacionalidade;

    @Column(nullable = true, unique = true, length = 25)
    private String naturalidade;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioEndereco")
    private List<EnderecoModel> endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioAgendamento")
    private List<AgendamentoModel> agendamento;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuarioFormulario")
    private FormularioModel formulario;





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

    public boolean isEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(boolean estadoCivil) {
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

    public List<EnderecoModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.endereco = endereco;
    }

    /*public List<AgendamentoModel> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<AgendamentoModel> agendamento) {
        this.agendamento = agendamento;
    }

    public List<FormularioModel> getFormulario() {
        return formulario;
    }

    public void setFormulario(List<FormularioModel> formulario) {
        this.formulario = formulario;
    }*/
}