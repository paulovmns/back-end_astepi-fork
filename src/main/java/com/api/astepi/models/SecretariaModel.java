package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_SECRETARIA")
public class SecretariaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 255)
    private String procedimento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "secretariaSecretario")
    private List<SecretarioModel> secretario;


    /*@OneToOne(fetch = FetchType.LAZY, mappedBy = "secretariaFormulario")
    private FormularioModel formulario;



    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "secretaria_agendamento", joinColumns = {
            @JoinColumn(name = "secretaria_id")}, inverseJoinColumns = {
            @JoinColumn(name = "agendamento_id")})
    Set<AgendamentoModel> agendamentos = new HashSet<AgendamentoModel>();*/




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public List<SecretarioModel> getSecretario() {
        return secretario;
    }

    public void setSecretario(List<SecretarioModel> secretario) {
        this.secretario = secretario;
    }

    /*public FormularioModel getFormulario() {
        return formulario;
    }

    public void setFormulario(FormularioModel formulario) {
        this.formulario = formulario;
    }

    public Set<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }*/
}
