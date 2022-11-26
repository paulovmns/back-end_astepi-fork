package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_SECRETARIA")
public class SecretariaModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    FormularioModel formularioModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FormularioModel getFormularioModel() {
        return formularioModel;
    }

    public void setFormularioModel(FormularioModel formularioModel) {
        this.formularioModel = formularioModel;
    }
}
