package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String rua;

    @Column(nullable = false, length = 15)
    private int numero;

    @Column(nullable = false, unique = true, length = 255)
    private String cep;

    @Column(nullable = false, unique = true, length = 255)
    private String complemento;

    @Column(nullable = false, length = 15)
    private int telefoneFixo;

    @Column(nullable = false, length = 15)
    private int celular;

    @Column(nullable = false, unique = true, length = 255)
    private String bairro;

    @Column(nullable = false, unique = true, length = 255)
    private String cidade;

    @Column(nullable = false, unique = true, length = 255)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_endereco_id")
    private UsuarioModel usuarioEndereco;

    public UsuarioModel getUsuarioEndereco() {
        return usuarioEndereco;
    }

    public void setUsuario_endereco(UsuarioModel usuarioEndereco) {
        this.usuarioEndereco = usuarioEndereco;
    }


    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getRua() {

        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) {

        this.numero = numero;
    }

    public String getCep() {

        return cep;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }

    public String getComplemento() {

        return complemento;
    }

    public void setComplemento(String complemento) {

        this.complemento = complemento;
    }

    public int getTelefoneFixo() {

        return telefoneFixo;
    }

    public void setTelefoneFixo(int telefoneFixo) {

        this.telefoneFixo = telefoneFixo;
    }

    public int getCelular() {

        return celular;
    }

    public void setCelular(int celular) {

        this.celular = celular;
    }

    public String getBairro() {

        return bairro;
    }

    public void setBairro(String bairro) {

        this.bairro = bairro;
    }

    public String getCidade() {

        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //public List<UsuarioModel> getUsuarioModel(){
       // return usuarios;
    //}
    //public void setUsuarioModel(List<UsuarioModel> usuarios) {
       // this.usuarios = usuarios;
   // }

    public boolean comprovanteResid() {
        String entregue = "N";
        if (entregue == "S") {
            return true;
        } else {
            return false;
        }
    }

}
