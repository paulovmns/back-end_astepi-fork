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
    private static final long serialVersionUID = 11;

    @Column(length = 10)
    private String sistema;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "administradorUsuario")
    private List<UsuarioModel> usuario;

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public List<UsuarioModel> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<UsuarioModel> usuario) {
        this.usuario = usuario;
    }
}
