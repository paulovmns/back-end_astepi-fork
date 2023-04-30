package com.api.astepi.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AdministradorModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 50)
    private String sistema;
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "administradorUsuario")
    private List<UsuarioModel> usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "administradorAdvogadoVoluntario")
    private List<AdvogadoVoluntarioModel> advogadoVoluntario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "administradorSecretario")
    private List<SecretarioModel> secretario;


    public List<AdvogadoVoluntarioModel> getAdvogadoVoluntario() {
        return advogadoVoluntario;
    }*/

    /*public void setAdvogadoVoluntario(List<AdvogadoVoluntarioModel> advogadoVoluntario) {
        this.advogadoVoluntario = advogadoVoluntario;
    }

    public List<SecretarioModel> getSecretario() {
        return secretario;
    }

    public void setSecretario(List<SecretarioModel> secretario) {
        this.secretario = secretario;
    }*/

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    /*public List<UsuarioModel> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<UsuarioModel> usuario) {
        this.usuario = usuario;
    }*/
}
