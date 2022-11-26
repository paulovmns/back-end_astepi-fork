package com.api.astepi.controllers;

import com.api.astepi.dtos.AdvogadoVoluntarioDto;
import com.api.astepi.services.AdvogadoVoluntarioService;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/PessoaModel")

public class AdvogadoVoluntarioController {

    final AdvogadoVoluntarioController advogadoVoluntarioControllerService;
    private final com.api.astepi.services.AdvogadoVoluntarioService AdvogadoVoluntarioService;

    public AdvogadoVoluntarioController(AdvogadoVoluntarioService advogadovoluntarioService) {
        this.AdvogadoVoluntarioService = advogadovoluntarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAdvogadoVoluntario(@RequestBody @Valid AdvogadoVoluntarioDto advogadoVoluntarioDto){
        var advogadoVolutarioModel = new AdvogadoVolutarioModel();
        BeanUtils.copyProperties(advogadoVoluntarioDto,advogadoVolutarioModel);
        advogadoVolutarioModel.setRegistrationform(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(advogadoVoluntarioControllerService.save(advogadoVolutarioModel));
    }

    private Object save(AdvogadoVolutarioModel advogadoVolutarioModel) {
    }

}
