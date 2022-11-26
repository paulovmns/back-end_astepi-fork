package com.api.astepi.repositories;

import com.api.astepi.models.DocumentoModel;
import com.api.astepi.models.FormularioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormularioRepository extends JpaRepository<FormularioModel, UUID> {

}
