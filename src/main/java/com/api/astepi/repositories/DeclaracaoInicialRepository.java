package com.api.astepi.repositories;

import com.api.astepi.models.DeclaracaoInicialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeclaracaoInicialRepository extends JpaRepository<DeclaracaoInicialModel, UUID> {

}
