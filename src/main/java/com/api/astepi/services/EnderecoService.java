package com.api.astepi.services;

import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.EnderecoRepository;
import com.api.astepi.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EnderecoService {
    final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public EnderecoModel save(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }
}
