package com.api.astepi.repositories;

import com.api.astepi.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    /**
     * Método que retorna uma lista de usuários fazendo a busca pelo nome
     passado como parâmetro.
     *
     * @param name
     * @return lista de usuários
     */
    List<UsuarioModel> findByNome(@Param("name") String name);

    /**
     * Método que retorna o usuario com apenas o seu nome fazendo a busca
     com o id passado como parâmetro.
     *
     * @param id
     * @return usuário do id passado como parâmetro.
     */
    @Query("SELECT c.nome FROM UsuarioModel c where c.id = :id")
    UsuarioModel findNomeById(@Param("id") Long id);

    /**
     * Método que retorna uma lista de usuarios fazendo a busca pelo nome passado
     como parâmetro e ordenando os
     * usuarios pelo nome.
     *
     * @param name
     * @return lista de clientes
     */
    List<UsuarioModel> findByNomeOrderByNome(@Param("name") String name);
}
