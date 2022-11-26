package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_DECLARACAOINICIAL")

public class DeclaracaoInicialModel {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String narrativa;

    @Column(nullable = false, unique = true, length = 255)
    private boolean parecerVoluntario;

    @Column(nullable = false, unique = true, length = 255)
    private boolean homologacaoDocente;

    @Column(nullable = false, unique = true, length = 255)
    AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNarrativa() {
        return narrativa;
    }

    public void setNarrativa(String narrativa) {
        this.narrativa = narrativa;
    }

    public boolean isParecerVoluntario() {
        return parecerVoluntario;
    }

    public void setParecerVoluntario(boolean parecerVoluntario) {
        this.parecerVoluntario = parecerVoluntario;
    }

    public boolean isHomologacaoDocente() {
        return homologacaoDocente;
    }

    public void setHomologacaoDocente(boolean homologacaoDocente) {
        this.homologacaoDocente = homologacaoDocente;
    }

    public AdvogadoVoluntarioModel getAdvogadoVoluntarioModel() {
        return advogadoVoluntarioModel;
    }

    public void setAdvogadoVoluntarioModel(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        this.advogadoVoluntarioModel = advogadoVoluntarioModel;
    }
}
