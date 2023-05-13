package com.api.astepi.services;

import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.AnaliseSocioEconomicaRepository;
import com.api.astepi.repositories.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnaliseSocioEconomicaService {
    final AnaliseSocioEconomicaRepository analiseSocioEconomicaRepository;

    public AnaliseSocioEconomicaService(AnaliseSocioEconomicaRepository analiseSocioEconomicaRepository){
        this.analiseSocioEconomicaRepository = analiseSocioEconomicaRepository;
    }

    @Transactional
    public AnaliseSocioEconomicaModel save(AnaliseSocioEconomicaModel analiseSocioEconomicaModel) {
        return analiseSocioEconomicaRepository.save(analiseSocioEconomicaModel);
    }

    public Page<AnaliseSocioEconomicaModel> findAll(Pageable pageable){
        return analiseSocioEconomicaRepository.findAll(pageable);
    }

    public Optional<AnaliseSocioEconomicaModel> findByID(UUID id) {
        return analiseSocioEconomicaRepository.findById(id);
    }

    @Transactional
    public void delete(AnaliseSocioEconomicaModel analiseSocioEconomicaModel) {
        analiseSocioEconomicaRepository.delete(analiseSocioEconomicaModel);
    }

}
