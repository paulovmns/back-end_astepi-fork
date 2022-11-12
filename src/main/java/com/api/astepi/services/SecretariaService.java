package com.api.astepi.services;

import com.api.astepi.models.SecretariaModel;
import com.api.astepi.models.SecretarioModel;
import com.api.astepi.repositories.SecretariaRepository;
import com.api.astepi.repositories.SecretarioRepository;

import javax.transaction.Transactional;

public class SecretariaService {
    public Object save(SecretariaModel secretariaModel) {
    }
    final SecretariaRepository secretariaRepository;

    public SecretariaService(SecretariaRepository secretariaRepository){
        this.secretariaRepository = secretariaRepository;
    }

    @Transactional
    public SecretariaModel save(SecretariaModel administradorModel) { return secretariaRepository.save(administradorModel); }

}
