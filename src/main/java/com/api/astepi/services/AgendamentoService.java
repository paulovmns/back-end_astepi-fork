package com.api.astepi.services;

import com.api.astepi.models.AgendamentoModel;
import com.api.astepi.repositories.AgendamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendamentoService {
    final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }

    @Transactional
    public AgendamentoModel save(AgendamentoModel agendamentoModel) {
        return agendamentoRepository.save(agendamentoModel);
    }

    public Page<AgendamentoModel> findAll(Pageable pageable){
        return agendamentoRepository.findAll(pageable);
    }

    public Optional<AgendamentoModel> findByID(UUID id) {
        return agendamentoRepository.findById(id);
    }

    @Transactional
    public void delete(AgendamentoModel agendamentoModel) {
        agendamentoRepository.delete(agendamentoModel);
    }

}
