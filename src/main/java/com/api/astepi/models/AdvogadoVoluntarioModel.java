package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class AdvogadoVoluntarioModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(unique = true, length = 50)
    private String numOAB;

    @Column(length = 255)
    private String formacaoAcad;

    /*@ManyToOne
    @JoinColumn(name = "usuario_advogadovoluntario_id")
    private UsuarioModel usuarioAdvogadoVoluntario;

    @ManyToOne
    @JoinColumn(name = "administrador_advogadovoluntario_id")
    private AdministradorModel administradorAdvogadoVoluntario;


    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "advvoluntario_endereco",
            joinColumns = {
                    @JoinColumn(name = "advgvoluntario_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "endereco_id")
            }
    )
    Set<EnderecoModel> enderecos = new HashSet<EnderecoModel>();*/

    /*public AdministradorModel getAdministradorAdvogadoVoluntario() {
        return administradorAdvogadoVoluntario;
    }

    public void setAdministradorAdvogadoVoluntario(AdministradorModel administradorAdvogadoVoluntario) {
        this.administradorAdvogadoVoluntario = administradorAdvogadoVoluntario;
    }

    public Set<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    public UsuarioModel getUsuarioAdvogadoVoluntario() {
        return usuarioAdvogadoVoluntario;
    }

    public void setUsuarioAdvogadoVoluntario(UsuarioModel usuarioAdvogadoVoluntario) {
        this.usuarioAdvogadoVoluntario = usuarioAdvogadoVoluntario;
    }*/



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

}
