package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.AdvogadoVoluntarioDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.AdvogadoVoluntarioModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.AdvogadoVoluntarioService;
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
@RequestMapping("/advogadovoluntarios")
public class AdvogadoVoluntarioController {
    final AdvogadoVoluntarioService advogadoVoluntarioService;

    public AdvogadoVoluntarioController(AdvogadoVoluntarioService advogadoVoluntarioService) {
        this.advogadoVoluntarioService = advogadoVoluntarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAdvogadoVoluntario(@RequestBody @Valid AdvogadoVoluntarioDto advogadoVoluntarioDto){
        var advogadoVoluntarioModel = new AdvogadoVoluntarioModel();
        BeanUtils.copyProperties(advogadoVoluntarioDto,advogadoVoluntarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(advogadoVoluntarioService.save(advogadoVoluntarioModel));
    }

    @GetMapping
    public ResponseEntity<Page<AdvogadoVoluntarioModel>> getAllAdvogadoVoluntario(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(advogadoVoluntarioService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAdvogadoVoluntario(@PathVariable (value = "id") UUID id){
        Optional<AdvogadoVoluntarioModel> advogadoVoluntarioModelOptional = advogadoVoluntarioService.finByID(id);
        if(!advogadoVoluntarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AdvogadoVoluntario not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(advogadoVoluntarioModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdvogadoVoluntario(@PathVariable (value = "id")UUID id){
        Optional<AdvogadoVoluntarioModel> advogadoVoluntarioModelOptional = advogadoVoluntarioService.finByID(id);
        if(!advogadoVoluntarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AdvogadoVoluntario not found.");
        }
        advogadoVoluntarioService.delete(advogadoVoluntarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("AdvogadoVoluntario deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdvogadoVoluntario(@PathVariable(value = "id")UUID id,@RequestBody @Valid AdvogadoVoluntarioDto advogadoVoluntarioDto){
        Optional<AdvogadoVoluntarioModel> advogadoVoluntarioModelOptional = advogadoVoluntarioService.finByID(id);
        if (!advogadoVoluntarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AdvogadoVoluntario not found.");
        }
        var advogadoVoluntarioModel = new AdvogadoVoluntarioModel();
        BeanUtils.copyProperties(advogadoVoluntarioDto, advogadoVoluntarioModel);
        advogadoVoluntarioModel.setId(advogadoVoluntarioModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(advogadoVoluntarioService.save(advogadoVoluntarioModel));
    }

}