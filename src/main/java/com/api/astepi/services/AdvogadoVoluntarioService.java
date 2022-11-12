package com.api.astepi.services;

import com.api.astepi.repositories.AdvogadoVoluntarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdvogadoVoluntarioService {
    final AdvogadoVoluntarioRepository advogadoVoluntarioRepository;

    public AdvogadoVoluntarioService(AdvogadoVoluntarioRepository advogadoVoluntarioRepository){
        this.advogadoVoluntarioRepository = advogadoVoluntarioRepository;
    }

    @Transactional
    public AdvogadoVolutarioModel save(AdvogadoVolutarioModel advogadoVolutarioModel) {
        return advogadoVoluntarioRepository.save(advogadoVolutarioModel);
    }
}
