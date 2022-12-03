package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 255)
    private String rua;

    @Column(length = 15)
    private int numero;

    @Column(length = 15)
    private String cep;

    @Column(length = 255)
    private String complemento;

    @Column(length = 15)
    private int telefoneFixo;

    @Column(length = 15)
    private int celular;

    @Column(length = 255)
    private String bairro;

    @Column(length = 255)
    private String cidade;

    @Column(length = 100)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_endereco_id")
    private UsuarioModel usuarioEndereco;

    @ManyToMany(mappedBy = "enderecos", cascade = { CascadeType.ALL })
    private Set<AgendamentoModel> agendamentos= new HashSet<AgendamentoModel>();

    @ManyToMany(mappedBy = "enderecos", cascade = { CascadeType.ALL })
    private Set<AdvogadoVoluntarioModel> advogadosvoluntarios = new HashSet<AdvogadoVoluntarioModel>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(int telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioModel getUsuarioEndereco() {
        return usuarioEndereco;
    }

    public void setUsuarioEndereco(UsuarioModel usuarioEndereco) {
        this.usuarioEndereco = usuarioEndereco;
    }

    public Set<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Set<AdvogadoVoluntarioModel> getAdvogadosvoluntarios() {
        return advogadosvoluntarios;
    }

    public void setAdvogadosvoluntarios(Set<AdvogadoVoluntarioModel> advogadosvoluntarios) {
        this.advogadosvoluntarios = advogadosvoluntarios;
    }

    public boolean comprovanteResid() {
        String entregue = "N";
        if (entregue == "S") {
            return true;
        } else {
            return false;
        }
    }

}
