package com.api.astepi.controllers;


import com.api.astepi.dtos.FormularioDto;
import com.api.astepi.models.FormularioModel;
import com.api.astepi.services.FormularioService;
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
@RequestMapping("/formularios")
public class FormularioController {
    final FormularioService formularioService;

    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFormulario(@RequestBody @Valid FormularioDto formularioDto){
        var formularioModel = new FormularioModel();
        BeanUtils.copyProperties(formularioDto,formularioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(formularioService.save(formularioModel));
    }

    @GetMapping
    public ResponseEntity<Page<FormularioModel>> getAllFormulario(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(formularioService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFormulario(@PathVariable (value = "id") UUID id){
        Optional<FormularioModel> formularioModelOptional = formularioService.finByID(id);
        if(!formularioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulario not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(formularioModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFormulario(@PathVariable (value = "id")UUID id){
        Optional<FormularioModel> formularioModelOptional = formularioService.finByID(id);
        if(!formularioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulario not found.");
        }
        formularioService.delete(formularioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Formulario deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFormulario(@PathVariable(value = "id")UUID id,@RequestBody @Valid FormularioDto formularioDto){
        Optional<FormularioModel> formularioModelOptional = formularioService.finByID(id);
        if (!formularioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulario not found.");
        }
        var formularioModel = new FormularioModel();
        BeanUtils.copyProperties(formularioDto, formularioModel);
        formularioModel.setId(formularioModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(formularioService.save(formularioModel));
    }
    
}
