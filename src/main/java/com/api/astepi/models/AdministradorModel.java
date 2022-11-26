package com.api.astepi.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name = "TB_ADMINISTRADOR")
public class AdministradorModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    UsuarioModel usuarioModel;

    @OneToMany(targetEntity= UsuarioModel.class, fetch=FetchType.EAGER)
    @JoinColumn(name="usuario_id")
    private List<UsuarioModel> usuarios;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    /*public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }
     */
    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
    public List<UsuarioModel> getUsuarioModel(){
        return usuarios;
    }
    public void setUsuarioModel(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }


}
