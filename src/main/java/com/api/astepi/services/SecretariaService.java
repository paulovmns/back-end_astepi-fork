package com.api.astepi.services;

import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.SecretariaModel;
import com.api.astepi.repositories.AnaliseSocioEconomicaRepository;
import com.api.astepi.repositories.SecretariaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecretariaService {
    final SecretariaRepository secretariaRepository;

    public SecretariaService(SecretariaRepository secretariaRepository){
        this.secretariaRepository = secretariaRepository;
    }

    @Transactional
    public SecretariaModel save(SecretariaModel secretariaModel) {
        return secretariaRepository.save(secretariaModel);
    }

    public Page<SecretariaModel> findAll(Pageable pageable){
        return secretariaRepository.findAll(pageable);
    }

    public Optional<SecretariaModel> finByID(UUID id) {
        return secretariaRepository.findById(id);
    }

    @Transactional
    public void delete(SecretariaModel secretariaModel) {
        secretariaRepository.delete(secretariaModel);
    }

}
