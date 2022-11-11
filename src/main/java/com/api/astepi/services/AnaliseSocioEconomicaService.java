package com.api.astepi.services;

import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.AnaliseSocioEconomicaRepository;
import com.api.astepi.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
