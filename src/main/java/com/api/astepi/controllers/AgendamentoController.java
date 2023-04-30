package com.api.astepi.controllers;


import com.api.astepi.dtos.AgendamentoDto;
import com.api.astepi.models.AgendamentoModel;
import com.api.astepi.models.UsuarioModel;
import com.api.astepi.services.AgendamentoService;
import com.api.astepi.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final UsuarioService usuarioService;

    public AgendamentoController(AgendamentoService agendamentoService, UsuarioService usuarioService) {
        this.agendamentoService = agendamentoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAgendamento(@RequestBody @Valid AgendamentoDto agendamentoDto) {
        var agendamentoModel = new AgendamentoModel();
        BeanUtils.copyProperties(agendamentoDto, agendamentoModel);

        // verifica se o usuário existe antes de associá-lo ao agendamento
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findByID(agendamentoDto.getUsuarioId());
        if (usuarioModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        // associa o usuário ao agendamento
        agendamentoModel.setUsuario(usuarioModelOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.save(agendamentoModel));
    }

    @GetMapping
    public ResponseEntity<Page<AgendamentoModel>> getAllAgendamento(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAgendamento(@PathVariable(value = "id") UUID id) {
        Optional<AgendamentoModel> agendamentoModelOptional = agendamentoService.findByID(id);
        if (!agendamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAgendamento(@PathVariable(value = "id") UUID id) {
        Optional<AgendamentoModel> agendamentoModelOptional = agendamentoService.findByID(id);
        if (!agendamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado.");
        }
        agendamentoService.delete(agendamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento excluído com sucesso.");
    }

    @PutMapping("/{id}")
        public ResponseEntity<Object> updateAgendamento(@PathVariable(value = "id")UUID id, @RequestBody @Valid AgendamentoDto agendamentoDto){
            Optional<AgendamentoModel> agendamentoModelOptional = agendamentoService.findByID(id);
            if (!agendamentoModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found.");
            }

            // Atualiza as informações do agendamento
            AgendamentoModel agendamentoModel = agendamentoModelOptional.get();
            BeanUtils.copyProperties(agendamentoDto, agendamentoModel, "id");
            agendamentoModel.setId(id);

            // Verifica se o usuário foi especificado na requisição e atualiza as informações do usuário associado
            if (agendamentoDto.getUsuarioId() != null) {
                Optional<UsuarioModel> usuarioModelOptional = usuarioService.findByID(agendamentoDto.getUsuarioId());
                if (!usuarioModelOptional.isPresent()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado.");
                }
                UsuarioModel usuarioModel = usuarioModelOptional.get();
                agendamentoModel.setUsuario(usuarioModel);
            }

            return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.save(agendamentoModel));
        }


//    @PostMapping
//    public ResponseEntity<Object> saveAgendamento(@RequestBody @Valid AgendamentoDto agendamentoDto){
//        var agendamentoModel = new AgendamentoModel();
//        BeanUtils.copyProperties(agendamentoDto,agendamentoModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.save(agendamentoModel));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<AgendamentoModel>> getAllAgendamento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
//        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.findAll(pageable));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getOneAgendamento(@PathVariable (value = "id") UUID id){
//        Optional<AgendamentoModel> agendamentoModelOptional = agendamentoService.finByID(id);
//        if(!agendamentoModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found.");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(agendamentoModelOptional.get());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteAgendamento(@PathVariable (value = "id")UUID id){
//        Optional<AgendamentoModel> agendamentoModelOptional = agendamentoService.finByID(id);
//        if(!agendamentoModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found.");
//        }
//        agendamentoService.delete(agendamentoModelOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("Agendamento deleted successfully.");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateAgendamento(@PathVariable(value = "id")UUID id,@RequestBody @Valid AgendamentoDto agendamentoDto){
//        Optional<AgendamentoModel> agendamentoModelOptional = agendamentoService.finByID(id);
//        if (!agendamentoModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found.");
//        }
//        var agendamentoModel = new AgendamentoModel();
//        BeanUtils.copyProperties(agendamentoDto, agendamentoModel);
//        agendamentoModel.setId(agendamentoModelOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.save(agendamentoModel));
//    }
    
}
