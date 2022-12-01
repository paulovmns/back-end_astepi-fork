package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class AdvogadoVoluntarioModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 1l;



    @Column(nullable = true, unique = true, length = 255)
    private String numOAB;

    @Column(nullable = true, unique = true, length = 255)
    private String formacaoAcad;

    @Column(nullable = true, unique = true, length = 255)
    UsuarioModel usuarioModel;


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
