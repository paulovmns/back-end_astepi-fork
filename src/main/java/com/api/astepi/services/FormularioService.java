package com.api.astepi.services;

import com.api.astepi.models.FormularioModel;
import com.api.astepi.repositories.FormularioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class FormularioService {
    final FormularioRepository formularioRepository;

    public FormularioService(FormularioRepository formularioRepository){
        this.formularioRepository = formularioRepository;
    }

    @Transactional
    public FormularioModel save(FormularioModel formularioModel) {
        return formularioRepository.save(formularioModel);
    }

    public Page<FormularioModel> findAll(Pageable pageable){
        return formularioRepository.findAll(pageable);
    }

    public Optional<FormularioModel> finByID(UUID id) {
        return formularioRepository.findById(id);
    }

    @Transactional
    public void delete(FormularioModel formularioModel) {
        formularioRepository.delete(formularioModel);
    }

}
