package com.api.astepi.services;

import com.api.astepi.models.DocumentoModel;
import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.EnderecoRepository;
import com.api.astepi.repositories.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

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

    public Page<EnderecoModel> findAll(Pageable pageable){
        return enderecoRepository.findAll(pageable);
    }

    public Optional<EnderecoModel> findByID(UUID id) {
        return enderecoRepository.findById(id);
    }

    @Transactional
    public void delete(EnderecoModel enderecoModel) {
        enderecoRepository.delete(enderecoModel);
    }

}
