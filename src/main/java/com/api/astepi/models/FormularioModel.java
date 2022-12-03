package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_FORMULARIO")
public class FormularioModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    /*@Column(length = 255)
    SecretariaModel secretariaModel;*/

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "tb_formulario_usuario_model",
            joinColumns = @JoinColumn(name = "formulario_model_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_model_id"))
    private UsuarioModel usuarioFormulario;

    public UsuarioModel getUsuarioFormulario() {
        return usuarioFormulario;
    }

    public void setUsuarioFormulario(UsuarioModel usuarioFormulario) {
        this.usuarioFormulario = usuarioFormulario;
    }


    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioModel_id")
    private UsuarioModel usuarioModel;*/


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


   /* public SecretariaModel getSecretariaModel() {
        return secretariaModel;
    }

    public void setSecretariaModel(SecretariaModel secretariaModel) {
        this.secretariaModel = secretariaModel;
    }
/*
    public UsuarioModel getUsuario() {
        return usuarioModel;
    }

    public void setUsuario(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }


 */
}
