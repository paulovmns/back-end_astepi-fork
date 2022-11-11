package com.api.astepi.repositories;

import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.PastaAtendimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PastaAtendimentoRepository extends JpaRepository<PastaAtendimentoModel, UUID> {

}
