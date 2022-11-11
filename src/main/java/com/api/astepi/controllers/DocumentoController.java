package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
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
@RequestMapping("/DocumentoModel")
public class DocumentoController {
    final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDocumento(@RequestBody @Valid DocumentoDto documentoDto){
        var documentoModel = new DocumentoModel();
        BeanUtils.copyProperties(documentoDto,documentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(documentoService.save(documentoModel));
    }
}
