package com.api.astepi.controllers;


import com.api.astepi.dtos.AdministradorDto;
import com.api.astepi.dtos.SecretarioDto;
import com.api.astepi.models.AdministradorModel;
import com.api.astepi.models.SecretarioModel;
import com.api.astepi.services.SecretarioService;


import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/SecretarioModel")

public class SecretarioController {

    final SecretarioService secretarioService;

    public SecretarioController(SecretarioService secretarioService) { this.secretarioService = secretarioService; }

    @PostMapping
    public ResponseEntity<Object> saveSecretario(@RequestBody @Valid SecretarioDto secretarioDto){
        var secretarioModel = new SecretarioModel();
        BeanUtils.copyProperties(secretarioDto,secretarioModel);
        secretarioModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(secretarioService.save(secretarioModel));
    }
    @GetMapping
    public ResponseEntity<Page<SecretarioModel>> getAllSecretario(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(secretarioService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSecretario(@PathVariable (value = "id") UUID id){
        Optional<SecretarioModel> secretarioModelOptional = secretarioService.finByID(id);
        if(!secretarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Secretario not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(secretarioModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSecretario(@PathVariable (value = "id")UUID id){
        Optional<SecretarioModel> secretarioModelOptional = secretarioService.finByID(id);
        if(!secretarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Secretario not found.");
        }
        secretarioService.delete(secretarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Secretario deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSecretario(@PathVariable(value = "id")UUID id,@RequestBody @Valid SecretarioDto secretarioDto){
        Optional<SecretarioModel> secretarioModelOptional = secretarioService.finByID(id);
        if (!secretarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("secretario not found.");
        }
        var secretarioModel = new SecretarioModel();
        BeanUtils.copyProperties(secretarioDto, secretarioModel);
        secretarioModel.setId(secretarioModelOptional.get().getId());
        secretarioModel.setRegistrationDate(secretarioModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(secretarioService.save(secretarioModel));
    }


}