package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.DeclaracaoInicialDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.DeclaracaoInicialModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.DeclaracaoInicialService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/declaracoes")
public class DeclaracaoInicialController {
    final DeclaracaoInicialService declaracaoInicialService;

    public DeclaracaoInicialController(DeclaracaoInicialService declaracaoInicialService) {
        this.declaracaoInicialService = declaracaoInicialService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDeclaracaoInicial(@RequestBody @Valid DeclaracaoInicialDto declaracaoInicialDto){
        var declaracaoInicialModel = new DeclaracaoInicialModel();
        BeanUtils.copyProperties(declaracaoInicialDto,declaracaoInicialModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(declaracaoInicialService.save(declaracaoInicialModel));
    }

    @GetMapping
    public ResponseEntity<Page<DeclaracaoInicialModel>> getAllDeclaracaoInicial(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(declaracaoInicialService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDeclaracaoInicial(@PathVariable (value = "id") UUID id){
        Optional<DeclaracaoInicialModel> declaracaoInicialModelOptional = declaracaoInicialService.findByID(id);
        if(!declaracaoInicialModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DeclaracaoInicial not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(declaracaoInicialModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDeclaracaoInicial(@PathVariable (value = "id")UUID id){
        Optional<DeclaracaoInicialModel> declaracaoInicialModelOptional = declaracaoInicialService.findByID(id);
        if(!declaracaoInicialModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DeclaracaoInicial not found.");
        }
        declaracaoInicialService.delete(declaracaoInicialModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("DeclaracaoInicial deleted successfully.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDeclaracaoInicial(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<String, Object> updates) {
        Optional<DeclaracaoInicialModel> declaracaoInicialOptional = declaracaoInicialService.findByID(id);
        if (declaracaoInicialOptional.isEmpty()) {
            throw new NotFoundException("Declaração Inicial not found.");
        }

        DeclaracaoInicialModel declaracaoInicial = declaracaoInicialOptional.get();
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = DeclaracaoInicialModel.class.getDeclaredField(key);
                field.setAccessible(true);
                field.set(declaracaoInicial, value);
            } catch (NoSuchFieldException e) {
                return ResponseEntity.badRequest().body("Campo inválido: " + key);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        declaracaoInicial.setId(id);
        declaracaoInicialService.save(declaracaoInicial);
        return ResponseEntity.status(HttpStatus.OK).body("Declaração Inicial atualizada com sucesso.");
    }



}
