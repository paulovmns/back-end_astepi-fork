package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PESSOA")

public class AdvogadoVolutarioModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID numOAB;

    @Column(nullable = false, unique = true, length = 50)
    private String formacaoAcad;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getnumOAB() {
        return numOAB;
    }

    public void setNumOAB(String numOAB) {
        this.numOAB = numOAB;
    }

    public String getFormacaoAcad() {
        return formacaoAcad;
    }

    public void setFormacaoAcad(String formacaoAcad) {
        this.formacaoAcad = formacaoAcad;
    }

    public void setRegistrationform(LocalDateTime utc) {
    }
}
