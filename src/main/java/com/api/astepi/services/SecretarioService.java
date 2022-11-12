package com.api.astepi.services;

import com.api.astepi.models.AdministradorModel;
import com.api.astepi.models.SecretarioModel;
import com.api.astepi.repositories.SecretarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;


@Service
public class SecretarioService {

    final SecretarioRepository secretarioRepository;

    public SecretarioService(SecretarioRepository secretarioRepository){
        this.secretarioRepository = secretarioRepository;
    }

    @Transactional
    public SecretarioModel save(SecretarioModel secretarioModel) { return secretarioRepository.save(secretarioModel); }

    public Page<SecretarioModel> findAll(Pageable pageable){ return secretarioRepository.findAll(pageable); }

    public Optional<SecretarioModel> finByID(UUID id) {
        return secretarioRepository.findById(id);
    }
    @Transactional
    public void delete(SecretarioModel secretarioModel) {
        secretarioRepository.delete(secretarioModel);
    }
}