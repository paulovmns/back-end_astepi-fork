package com.api.astepi.services;

import com.api.astepi.models.DocumentoModel;
import com.api.astepi.models.PastaAtendimentoModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.PastaAtendimentoRepository;
import com.api.astepi.repositories.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

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

    public Page<PastaAtendimentoModel> findAll(Pageable pageable){
        return pastaAtendimentoRepository.findAll(pageable);
    }

    public Optional<PastaAtendimentoModel> finByID(UUID id) {
        return pastaAtendimentoRepository.findById(id);
    }

    @Transactional
    public void delete(PastaAtendimentoModel pastaAtendimentoModel) {
        pastaAtendimentoRepository.delete(pastaAtendimentoModel);
    }

}
