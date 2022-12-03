package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SecretarioModel extends PessoaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length = 255)
    private String atribuicao;

    @ManyToOne
    @JoinColumn(name = "administrador_secretario_id")
    private AdministradorModel administradorSecretario;

    @ManyToOne
    @JoinColumn(name = "usuario_secretario_id")
    private UsuarioModel usuarioSecretario;

    @ManyToOne
    @JoinColumn(name = "secretaria_secretario_id")
    private SecretariaModel secretariaSecretario;

    public String getAtribuicao() {
        return atribuicao;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicao = atribuicao;
    }

    public AdministradorModel getAdministradorSecretario() {
        return administradorSecretario;
    }

    public void setAdministradorSecretario(AdministradorModel administradorSecretario) {
        this.administradorSecretario = administradorSecretario;
    }

    public UsuarioModel getUsuarioSecretario() {
        return usuarioSecretario;
    }

    public void setUsuarioSecretario(UsuarioModel usuarioSecretario) {
        this.usuarioSecretario = usuarioSecretario;
    }

    public SecretariaModel getSecretariaSecretario() {
        return secretariaSecretario;
    }

    public void setSecretariaSecretario(SecretariaModel secretariaSecretario) {
        this.secretariaSecretario = secretariaSecretario;
    }



}
