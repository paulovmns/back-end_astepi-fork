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

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/declaracaoInicials")
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
        Optional<DeclaracaoInicialModel> declaracaoInicialModelOptional = declaracaoInicialService.finByID(id);
        if(!declaracaoInicialModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DeclaracaoInicial not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(declaracaoInicialModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDeclaracaoInicial(@PathVariable (value = "id")UUID id){
        Optional<DeclaracaoInicialModel> declaracaoInicialModelOptional = declaracaoInicialService.finByID(id);
        if(!declaracaoInicialModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DeclaracaoInicial not found.");
        }
        declaracaoInicialService.delete(declaracaoInicialModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("DeclaracaoInicial deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDeclaracaoInicial(@PathVariable(value = "id")UUID id,@RequestBody @Valid DeclaracaoInicialDto declaracaoInicialDto){
        Optional<DeclaracaoInicialModel> declaracaoInicialModelOptional = declaracaoInicialService.finByID(id);
        if (!declaracaoInicialModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DeclaracaoInicial not found.");
        }
        var declaracaoInicialModel = new DeclaracaoInicialModel();
        BeanUtils.copyProperties(declaracaoInicialDto, declaracaoInicialModel);
        declaracaoInicialModel.setId(declaracaoInicialModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(declaracaoInicialService.save(declaracaoInicialModel));
    }

}
