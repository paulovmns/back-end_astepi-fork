package com.api.astepi.controllers;


import com.api.astepi.dtos.EnderecoDto;
import com.api.astepi.dtos.PastaAtendimentoDto;
import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.PastaAtendimentoModel;
import com.api.astepi.services.EnderecoService;
import com.api.astepi.services.PastaAtendimentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/PastaAtendimentoModel")
public class PastaAtendimentoController {
    final PastaAtendimentoService pastaAtendimentoService;

    public PastaAtendimentoController(PastaAtendimentoService pastaAtendimentoService) {
        this.pastaAtendimentoService = pastaAtendimentoService;
    }

    @PostMapping
    public ResponseEntity<Object> savePastaAtendimento(@RequestBody @Valid PastaAtendimentoDto pastaAtendimentoDto){
        var pastaAtendimentoModel = new PastaAtendimentoModel();
        BeanUtils.copyProperties(pastaAtendimentoDto,pastaAtendimentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pastaAtendimentoService.save(pastaAtendimentoModel));
    }
}
