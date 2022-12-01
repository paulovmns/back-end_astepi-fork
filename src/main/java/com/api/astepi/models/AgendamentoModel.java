package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 2)
    private int dia;

    @Column(nullable = false, length = 2)
    private int mes;

    @Column(nullable = false, length = 4)
    private int ano;

    @Column(nullable = false, length = 4)
    private int horario;

    @Column(nullable = false, unique = true, length = 255)
    private String sala;


    @Column(nullable = false, unique = true, length = 255)
    SecretariaModel secretariaModel;

    @Column(nullable = false, unique = true, length = 255)
    EnderecoModel enderecoModel;

    @Column(nullable = false, unique = true, length = 255)
    DocumentoModel documentoModel;

    @ManyToOne
    @JoinColumn(name = "usuario_agendamento_id")
    private UsuarioModel usuarioAgendamento;

    public UsuarioModel getUsuarioAgendamento() {
        return usuarioAgendamento;
    }

    public void setUsuarioAgendamento(UsuarioModel usuarioAgendamento) {
        this.usuarioAgendamento = usuarioAgendamento;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioModel_id")
    private UsuarioModel usuarioModel;*/


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
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

    public void setSecretariaModel(SecretariaModel secretariaModel) {
        this.secretariaModel = secretariaModel;
    }

    public EnderecoModel getEnderecoModel() {
        return enderecoModel;
    }

    public void setEnderecoModel(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }

    public DocumentoModel getDocumentoModel() {
        return documentoModel;
    }

    public void setDocumentoModel(DocumentoModel documentoModel) {
        this.documentoModel = documentoModel;
    }
}
