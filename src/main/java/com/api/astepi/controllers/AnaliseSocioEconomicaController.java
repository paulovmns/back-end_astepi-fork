package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.PessoaDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/AnaliseSocioEconomicaModel")
public class AnaliseSocioEconomicaController {
    final AnaliseSocioEconomicaService analiseSocioEconomicaService;

    public AnaliseSocioEconomicaController(AnaliseSocioEconomicaService analiseSocioEconomicaService) {
        this.analiseSocioEconomicaService = analiseSocioEconomicaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAnaliseSocioEconomica(@RequestBody @Valid AnaliseSocioEconomicaDto analiseSocioEconomicaDto){
        var analiseSocioEconomicaModel = new AnaliseSocioEconomicaModel();
        BeanUtils.copyProperties(analiseSocioEconomicaDto,analiseSocioEconomicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(analiseSocioEconomicaService.save(analiseSocioEconomicaModel));
    }
}
