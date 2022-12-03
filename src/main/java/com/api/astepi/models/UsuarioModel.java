package com.api.astepi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@DiscriminatorValue(value="USUARIOMODEL")
public class UsuarioModel extends PessoaModel  {
    private static final long serialVersionUID = 11;


    @Column(length = 10)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;

    @Column(length = 50)
    private String profissao;

    @Column(length =25)
    private boolean estadoCivil;

    @Column(length = 25)
    private String nacionalidade;

    @Column(length = 25)
    private String naturalidade;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioEndereco")
    private List<EnderecoModel> endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioAgendamento")
    private List<AgendamentoModel> agendamento;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuarioFormulario")
    private FormularioModel formulario;

    @ManyToOne
    @JoinColumn(name = "administrador_usuario_id")
    private AdministradorModel administradorUsuario;

    public AdministradorModel getAdministradorUsuario() {
        return administradorUsuario;
    }

    public void setAdministradorUsuario(AdministradorModel administradorUsuario) {
        this.administradorUsuario = administradorUsuario;
    }


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

    public List<AgendamentoModel> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<AgendamentoModel> agendamento) {
        this.agendamento = agendamento;
    }

    public FormularioModel getFormulario() {
        return formulario;
    }

    public void setFormulario(FormularioModel formulario) {
        this.formulario = formulario;
    }
}