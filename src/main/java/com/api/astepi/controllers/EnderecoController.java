package com.api.astepi.controllers;


import com.api.astepi.dtos.AgendamentoDto;
import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.EnderecoDto;
import com.api.astepi.models.AgendamentoModel;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.UsuarioModel;
import com.api.astepi.services.AgendamentoService;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.EnderecoService;
import com.api.astepi.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;
    private final UsuarioService usuarioService;

    public EnderecoController(EnderecoService enderecoService, UsuarioService usuarioService) {
        this.enderecoService = enderecoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(enderecoDto,enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoModel));
    }

    @GetMapping
    public ResponseEntity<Page<EnderecoModel>> getAllEndereco(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEndereco(@PathVariable (value = "id") UUID id){
        Optional<EnderecoModel> enderecoModelOptional = enderecoService.findByID(id);
        if(!enderecoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEndereco(@PathVariable (value = "id")UUID id){
        Optional<EnderecoModel> enderecoModelOptional = enderecoService.findByID(id);
        if(!enderecoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco not found.");
        }
        enderecoService.delete(enderecoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereco deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<String, Object> updates) {
        Optional<EnderecoModel> enderecoOptional = enderecoService.findByID(id);
        if (enderecoOptional.isEmpty()) {
            throw new NotFoundException("Endereco not found.");
        }

        EnderecoModel endereco = enderecoOptional.get();
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(EnderecoModel.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, endereco, value);
            }
        });

        endereco.setId(id);
        enderecoService.save(endereco);
        return ResponseEntity.status(HttpStatus.OK).body("Endereco atualizado com sucesso.");
    }


    //    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id")UUID id, @RequestBody @Valid EnderecoDto enderecoDto){
//        Optional<EnderecoModel> enderecoModelOptional = enderecoService.findByID(id);
//        if (!enderecoModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco not found.");
//        }
//
//        // Atualiza as informações do endereco
//        EnderecoModel enderecoModel = enderecoModelOptional.get();
//        BeanUtils.copyProperties(enderecoDto, enderecoModel, "id");
//        enderecoModel.setId(id);
//
//        // Verifica se o usuário foi especificado na requisição e atualiza as informações do usuário associado
//        if (enderecoDto.getUsuarioId() != null) {
//            Optional<UsuarioModel> usuarioModelOptional = usuarioService.findByID(enderecoDto.getUsuarioId());
//            if (!usuarioModelOptional.isPresent()) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado.");
//            }
//            UsuarioModel usuarioModel = usuarioModelOptional.get();
//            enderecoModel.setUsuario(usuarioModel);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(enderecoModel));
//    }
    
}
