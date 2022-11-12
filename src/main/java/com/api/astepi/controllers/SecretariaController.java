package com.api.astepi.controllers;


import com.api.astepi.dtos.SecretariaDto;
import com.api.astepi.models.SecretariaModel;
import com.api.astepi.services.SecretariaService;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/SecretariaModel")

public class SecretariaController {

    final SecretariaService secretariaService;

    public SecretariaController(SecretariaService secretariaService) { this.secretariaService = secretariaService; }

    @PostMapping
    public ResponseEntity<Object> saveSecretaria(@RequestBody @Valid SecretariaDto secretarioDto){
        var secretariaModel = new SecretariaModel();
        BeanUtils.copyProperties(secretarioDto,secretariaModel);
        secretariaModel.setRegistratinForm(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(secretariaService.save(secretariaModel));
    }


}