package com.api.astepi.services;

import com.api.astepi.models.DeclaracaoInicialModel;
import com.api.astepi.models.DeclaracaoInicialModel;
import com.api.astepi.repositories.DeclaracaoInicialRepository;
import com.api.astepi.repositories.DeclaracaoInicialRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeclaracaoInicialService {
    final DeclaracaoInicialRepository declaracaoInicialRepository;

    public DeclaracaoInicialService(DeclaracaoInicialRepository declaracaoInicialRepository){
        this.declaracaoInicialRepository = declaracaoInicialRepository;
    }

    @Transactional
    public DeclaracaoInicialModel save(DeclaracaoInicialModel declaracaoInicialModel) {
        return declaracaoInicialRepository.save(declaracaoInicialModel);
    }

    public Page<DeclaracaoInicialModel> findAll(Pageable pageable){
        return declaracaoInicialRepository.findAll(pageable);
    }

    public Optional<DeclaracaoInicialModel> finByID(UUID id) {
        return declaracaoInicialRepository.findById(id);
    }

    @Transactional
    public void delete(DeclaracaoInicialModel declaracaoInicialModel) {
        declaracaoInicialRepository.delete(declaracaoInicialModel);
    }

}
