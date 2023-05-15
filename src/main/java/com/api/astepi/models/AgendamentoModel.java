package com.api.astepi.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 10)
    private String dia;

    @Column(length = 10)
    private String mes;

    @Column(length = 10)
    private String ano;

    @Column(length = 10)
    private String horario;

    @Column(columnDefinition="text", length=10485760)
    private String observacao;

    //@JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;


    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }



/*@ManyToMany(mappedBy = "agendamentos", cascade = { CascadeType.ALL })
    private Set<SecretariaModel> endereco= new HashSet<SecretariaModel>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "agendamento_endereco", joinColumns = {
            @JoinColumn(name = "agendamento_id")}, inverseJoinColumns = {
            @JoinColumn(name = "endereco_id")})
    Set<EnderecoModel> enderecos = new HashSet<EnderecoModel>();


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agendamentoDocumento")
    private List<DocumentoModel> documento;

    @ManyToOne
    @JoinColumn(name = "usuario_agendamento_id")
    private UsuarioModel usuarioAgendamento;*/

    /*public UsuarioModel getUsuarioAgendamento() {
        return usuarioAgendamento;
    }



    public void setUsuarioAgendamento(UsuarioModel usuarioAgendamento) {
        this.usuarioAgendamento = usuarioAgendamento;
    }*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /* public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }
    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
    public SecretariaModel getSecretariaModel() {
        return secretariaModel;
    }*/

    /*public Set<SecretariaModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<SecretariaModel> endereco) {
        this.endereco = endereco;
    }

    public Set<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    public List<DocumentoModel> getDocumento() {
        return documento;
    }

    public void setDocumento(List<DocumentoModel> documento) {
        this.documento = documento;
    }*/
}