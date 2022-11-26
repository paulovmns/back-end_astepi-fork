package com.api.astepi.services;

import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.repositories.AdvogadoVoluntarioRepository;
import com.api.astepi.repositories.AdvogadoVoluntarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdvogadoVoluntarioService {

    final AdvogadoVoluntarioRepository advogadoVoluntarioRepository;

    public AdvogadoVoluntarioService(AdvogadoVoluntarioRepository advogadoVoluntarioRepository){
        this.advogadoVoluntarioRepository = advogadoVoluntarioRepository;
    }

    @Transactional
    public AdvogadoVoluntarioModel save(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        return advogadoVoluntarioRepository.save(advogadoVoluntarioModel);
    }

    public Page<AdvogadoVoluntarioModel> findAll(Pageable pageable){
        return advogadoVoluntarioRepository.findAll(pageable);
    }

    public Optional<AdvogadoVoluntarioModel> finByID(UUID id) {
        return advogadoVoluntarioRepository.findById(id);
    }

    @Transactional
    public void delete(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        advogadoVoluntarioRepository.delete(advogadoVoluntarioModel);
    }



}
