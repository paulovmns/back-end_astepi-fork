package com.api.astepi.repositories;

import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {

/*

    List<EnderecoModel> findByNome(@Param("name") String name);


    @Query("SELECT c.nome FROM EnderecoModel c where c.id = :id")
    EnderecoModel findNomeById(@Param("id") Long id);

    List<EnderecoModel> findByNomeOrderByNome(@Param("name") String name);*/

}
