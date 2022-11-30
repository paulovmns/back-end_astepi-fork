package com.api.astepi.services;

import com.api.astepi.models.UsuarioModel;
import com.api.astepi.repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public Page<UsuarioModel> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Optional<UsuarioModel> finByID(UUID id) {
        return usuarioRepository.findById(id);
    }
    @Transactional
    public void delete(UsuarioModel usuarioModel) {
        usuarioRepository.delete(usuarioModel);
    }
}