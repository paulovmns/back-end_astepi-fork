package com.api.astepi.services;

import com.api.astepi.models.AdministradorModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.AdministradorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdministradorService {

    final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository){
        this.administradorRepository = administradorRepository;
    }

    @Transactional //caso dê errado na transação com DB, essa anotação garante que ñ tenham dados quebrados
    public AdministradorModel save(AdministradorModel administradorModel) { return administradorRepository.save(administradorModel); }
    public Page<AdministradorModel> findAll(Pageable pageable){ return administradorRepository.findAll(pageable); }

    public Optional<AdministradorModel> finByID(UUID id) {
        return administradorRepository.findById(id);
    }
    @Transactional
    public void delete(AdministradorModel administradorModel) {
        administradorRepository.delete(administradorModel);
    }

}
