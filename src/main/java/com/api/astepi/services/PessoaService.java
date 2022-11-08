package com.api.astepi.services;

import com.api.astepi.repositories.PessoaRepository;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }


}
