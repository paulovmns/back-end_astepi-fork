package com.api.astepi.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_DECLARACAOINICIAL")
public class DeclaracaoInicialModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition="text", length=10485760)
    private String narrativa;

    @Column(columnDefinition="text", length=10485760)
    private String parecerVoluntario;

    @Column
    private String homologacaoDocente;

    @Column(columnDefinition="text", length=10485760)
    private String homologacaoComentario;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    //@Column(nullable = false, unique = true, length = 255)
    //AdvogadoVoluntarioModel advogadoVoluntarioModel;

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

    public String getParecerVoluntario() {
        return parecerVoluntario;
    }

    public void setParecerVoluntario(String parecerVoluntario) {
        this.parecerVoluntario = parecerVoluntario;
    }

    public String getHomologacaoDocente() {
        return homologacaoDocente;
    }

    public void setHomologacaoDocente(String homologacaoDocente) {
        this.homologacaoDocente = homologacaoDocente;
    }

    public String getHomologacaoComentario() {
        return homologacaoComentario;
    }

    public void setHomologacaoComentario(String homologacaoComentario) {
        this.homologacaoComentario = homologacaoComentario;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
