package com.api.astepi.services;

import com.api.astepi.dtos.*;
import com.api.astepi.models.*;
import com.api.astepi.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.NoSuchElementException;
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

    public UsuarioModel setAnaliseSec(UUID usuarioId, AnaliseSocioEconomicaDto analiseSocioEconomicaDto) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        UsuarioModel usuarioModel = usuarioOptional.get();

        AnaliseSocioEconomicaModel analiseSocioEconomicaModel = new AnaliseSocioEconomicaModel();
        BeanUtils.copyProperties(analiseSocioEconomicaDto, analiseSocioEconomicaModel);
        analiseSocioEconomicaModel.setUsuario(usuarioModel);

        usuarioModel.setAnaliseSocioEconomica(analiseSocioEconomicaModel);

        usuarioModel = usuarioRepository.save(usuarioModel);

        return usuarioModel;
    }

    public UsuarioModel setDeclaracaoInicial(UUID usuarioId, DeclaracaoInicialDto declaracaoInicialDto) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        UsuarioModel usuarioModel = usuarioOptional.get();

        DeclaracaoInicialModel declaracaoInicialModel = new DeclaracaoInicialModel();
        BeanUtils.copyProperties(declaracaoInicialDto, declaracaoInicialModel);
        declaracaoInicialModel.setUsuario(usuarioModel);

        usuarioModel.setDeclaracaoInicial(declaracaoInicialModel);

        usuarioModel = usuarioRepository.save(usuarioModel);

        return usuarioModel;
    }


    @Transactional
    public void salvarDocumento(UUID usuarioId, MultipartFile arquivo, String descricao) throws IOException {
        UsuarioModel usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        DocumentoModel documento = new DocumentoModel();
        documento.setNome(arquivo.getOriginalFilename());
        documento.setTipo(arquivo.getContentType());
        documento.setTamanho(arquivo.getSize());
        documento.setArquivo(arquivo.getBytes());
        documento.setDataEnvio(LocalDateTime.now());
        documento.setDescricao(descricao);
        documento.setUsuario(usuario);

        usuario.getDocumentos().add(documento);

        usuarioRepository.save(usuario);


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