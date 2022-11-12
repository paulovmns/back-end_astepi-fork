package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_DECLARACAOINICIALMODEL")

public class DeclaracaoInicialModel {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String narrativa;


    @Column(nullable = false, unique = true, length = 255)
    private boolean parecerVoluntario;

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

    public boolean getParecerVoluntario() {
        return parecerVoluntario;
    }

    public void setParecerVoluntario(boolean parecerVoluntario) {
        this.parecerVoluntario = parecerVoluntario;
    }


}
