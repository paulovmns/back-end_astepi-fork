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


    @Column(nullable = true, unique = true, length = 255)
    UsuarioModel usuarioModel;





    /*public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }
     */
    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
    /*public List<UsuarioModel> getUsuarioModel(){
        return usuarios;
    }
    public void setUsuarioModel(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }*/


}
