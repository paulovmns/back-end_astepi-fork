package com.api.astepi.services;

import com.api.astepi.dtos.AgendamentoDto;
import com.api.astepi.dtos.EnderecoDto;
import com.api.astepi.models.AgendamentoModel;
import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.UsuarioModel;
import com.api.astepi.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioModel addAgendamento(UUID usuarioId, AgendamentoDto agendamentoDto) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        UsuarioModel usuarioModel = usuarioOptional.get();

        AgendamentoModel agendamentoModel = new AgendamentoModel();
        BeanUtils.copyProperties(agendamentoDto, agendamentoModel);
        agendamentoModel.setUsuario(usuarioModel);

        usuarioModel.getAgendamentos().add(agendamentoModel);

        usuarioModel = usuarioRepository.save(usuarioModel);

        return usuarioModel;
    }


    public UsuarioModel addEndereco(UUID usuarioId, EnderecoDto enderecoDto) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        UsuarioModel usuarioModel = usuarioOptional.get();

        EnderecoModel enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(enderecoDto, enderecoModel);
        enderecoModel.setUsuario(usuarioModel);

        usuarioModel.getEnderecos().add(enderecoModel);

        usuarioModel = usuarioRepository.save(usuarioModel);

        return usuarioModel;
    }



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

    public Optional<UsuarioModel> findByID(UUID id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void delete(UsuarioModel usuarioModel) {
        usuarioRepository.delete(usuarioModel);
    }
}