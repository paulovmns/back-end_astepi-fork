package com.api.astepi.services;

import com.api.astepi.models.DeclaracaoInicialModel;
import com.api.astepi.repositories.DeclaracaoInicialRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
