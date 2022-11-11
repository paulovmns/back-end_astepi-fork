package com.api.astepi.services;

import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.PessoaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {
    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional //caso dê errado na transação com DB, essa anotação garante que ñ tenham dados quebrados
    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    public Page<PessoaModel> findAll(Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    public Optional<PessoaModel> finByID(UUID id) {
        return pessoaRepository.findById(id);
    }
    @Transactional
    public void delete(PessoaModel pessoaModel) {
        pessoaRepository.delete(pessoaModel);
    }
}
