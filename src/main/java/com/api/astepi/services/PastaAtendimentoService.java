package com.api.astepi.services;

import com.api.astepi.models.PastaAtendimentoModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.PastaAtendimentoRepository;
import com.api.astepi.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PastaAtendimentoService {
    final PastaAtendimentoRepository pastaAtendimentoRepository;

    public PastaAtendimentoService(PastaAtendimentoRepository pastaAtendimentoRepository){
        this.pastaAtendimentoRepository = pastaAtendimentoRepository;
    }

    @Transactional
    public PastaAtendimentoModel save(PastaAtendimentoModel pastaAtendimentoModel) {
        return pastaAtendimentoRepository.save(pastaAtendimentoModel);
    }
}
