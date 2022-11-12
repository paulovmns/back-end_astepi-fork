package com.api.astepi.controllers;

import com.api.astepi.dtos.AdministradorDto;
import com.api.astepi.dtos.PessoaDto;
import com.api.astepi.models.AdministradorModel;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.services.AdministradorService;


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
@RequestMapping("/AdministradorModel")

public class AdministradorController {

    final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAdministrador(@RequestBody @Valid AdministradorDto administradorDto){
        var administradorModel = new AdministradorModel();
        BeanUtils.copyProperties(administradorDto,administradorModel);
        administradorModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.save(administradorModel));
    }
    @GetMapping
    public ResponseEntity<Page<AdministradorModel>> getAllAdministrador(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAdministrador(@PathVariable (value = "id") UUID id){
        Optional<AdministradorModel> administradorModelOptional = administradorService.finByID(id);
        if(!administradorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("administrador not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(administradorModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdministrador(@PathVariable (value = "id")UUID id){
        Optional<AdministradorModel> administradorModelOptional = administradorService.finByID(id);
        if(!administradorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("administrador not found.");
        }
        administradorService.delete(administradorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("administrador deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdministrador(@PathVariable(value = "id")UUID id,@RequestBody @Valid AdministradorDto administradorDto){
        Optional<AdministradorModel> administradorModelOptional = administradorService.finByID(id);
        if (!administradorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador not found.");
        }
        var administradorModel = new AdministradorModel();
        BeanUtils.copyProperties(administradorDto, administradorModel);
        administradorModel.setId(administradorModelOptional.get().getId());
        administradorModel.setRegistrationDate(administradorModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.save(administradorModel));
    }
}
