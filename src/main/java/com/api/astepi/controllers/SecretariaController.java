package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.SecretariaDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.SecretariaModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.SecretariaService;
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
@RequestMapping("/secretarias")
public class SecretariaController {
    final SecretariaService secretariaService;

    public SecretariaController(SecretariaService secretariaService) {
        this.secretariaService = secretariaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveSecretaria(@RequestBody @Valid SecretariaDto secretariaDto){
        var secretariaModel = new SecretariaModel();
        BeanUtils.copyProperties(secretariaDto,secretariaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(secretariaService.save(secretariaModel));
    }

    @GetMapping
    public ResponseEntity<Page<SecretariaModel>> getAllSecretaria(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(secretariaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSecretaria(@PathVariable (value = "id") UUID id){
        Optional<SecretariaModel> secretariaModelOptional = secretariaService.finByID(id);
        if(!secretariaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Secretaria not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(secretariaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSecretaria(@PathVariable (value = "id")UUID id){
        Optional<SecretariaModel> secretariaModelOptional = secretariaService.finByID(id);
        if(!secretariaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Secretaria not found.");
        }
        secretariaService.delete(secretariaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Secretaria deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSecretaria(@PathVariable(value = "id")UUID id,@RequestBody @Valid SecretariaDto secretariaDto){
        Optional<SecretariaModel> secretariaModelOptional = secretariaService.finByID(id);
        if (!secretariaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Secretaria not found.");
        }
        var secretariaModel = new SecretariaModel();
        BeanUtils.copyProperties(secretariaDto, secretariaModel);
        secretariaModel.setId(secretariaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(secretariaService.save(secretariaModel));
    }

}
