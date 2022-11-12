package com.api.astepi.controllers;

import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.DeclaracaoInicialDto;
import com.api.astepi.dtos.DocumentoDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.DocumentoModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.DocumentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/DeclaracaoInicialModel")

public class DeclaracaoInicialController {

    final DeclaracaoInicialService declaracaoinicialService;

    public DeclaracaoInicialController(DeclaracaoInicialService declaracaoinicialService) {
        this.declaracaoinicialService = declaracaoinicialService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDeclaracaoInicial(@RequestBody @Valid DeclaracaoInicialDto declaracaoinicialDto){
        var DeclaracaoInicialModel = new DeclaracaoInicialModel();
        BeanUtils.copyProperties(declaracaoinicialDto,declaracaoinicialModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(declaracaoinicialService.save(declaracaoinicialModel));
    }

}
