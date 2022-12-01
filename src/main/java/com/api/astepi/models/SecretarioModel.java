package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SecretarioModel extends PessoaModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Column(nullable = true, unique = true, length = 255)
    UsuarioModel usuarioModel;

    @Column(nullable = true, unique = true, length = 255)
    SecretariaModel secretariaModel;

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public SecretariaModel getSecretariaModel() {
        return secretariaModel;
    }

    public void setSecretariaModel(SecretariaModel secretariaModel) {
        this.secretariaModel = secretariaModel;
    }
}
