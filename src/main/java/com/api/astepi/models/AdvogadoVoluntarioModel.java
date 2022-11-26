package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ADVOGADOVOLUNTARIO")
public class AdvogadoVoluntarioModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String numOAB;

    @Column(nullable = false, unique = true, length = 255)
    private String formacaoAcad;

    @Column(nullable = false, unique = true, length = 255)
    UsuarioModel usuarioModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumOAB() {
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

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
}
