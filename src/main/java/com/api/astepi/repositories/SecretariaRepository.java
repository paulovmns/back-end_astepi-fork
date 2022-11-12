package com.api.astepi.repositories;

import com.api.astepi.models.SecretariaModel;
import com.api.astepi.models.SecretarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface SecretariaRepository extends JpaRepository<SecretariaModel, UUID>{

}