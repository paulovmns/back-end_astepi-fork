package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_FORMULARIO")
public class FormularioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 255)
    private String titulo;

    /*@OneToOne(orphanRemoval = true)
    @JoinTable(name = "tb_formulario_secretaria_model",
            joinColumns = @JoinColumn(name = "formulario_model_id"),
            inverseJoinColumns = @JoinColumn(name = "secretaria_model_id"))
    private SecretariaModel secretariaFormulario;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "tb_formulario_usuario_model",
            joinColumns = @JoinColumn(name = "formulario_model_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_model_id"))
    private UsuarioModel usuarioFormulario;*/



    /*public UsuarioModel getUsuarioFormulario() {
        return usuarioFormulario;
    }

    public void setUsuarioFormulario(UsuarioModel usuarioFormulario) {
        this.usuarioFormulario = usuarioFormulario;
    }

    public SecretariaModel getSecretariaFormulario() {
        return secretariaFormulario;
    }

    public void setSecretariaFormulario(SecretariaModel secretariaFormulario) {
        this.secretariaFormulario = secretariaFormulario;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
