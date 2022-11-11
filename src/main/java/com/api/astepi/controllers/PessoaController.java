package com.api.astepi.controllers;


import com.api.astepi.dtos.PessoaDto;
import com.api.astepi.models.PessoaModel;
import com.api.astepi.repositories.PessoaRepository;
import com.api.astepi.services.PessoaService;


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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/PessoaModel")
public class PessoaController {
    final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Object> savePessoa(@RequestBody @Valid PessoaDto pessoaDto){
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto,pessoaModel);
        pessoaModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaModel));
    }
    @GetMapping
    public ResponseEntity<Page<PessoaModel>> getAllPessoa(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoa(@PathVariable (value = "id")UUID id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.finByID(id);
        if(!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable (value = "id")UUID id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.finByID(id);
        if(!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa not found.");
        }
        pessoaService.delete(pessoaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id")UUID id,@RequestBody @Valid PessoaDto pessoaDto){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.finByID(id);
        if (!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa not found.");
        }
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setId(pessoaModelOptional.get().getId());
        pessoaModel.setRegistrationDate(pessoaModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaModel));
    }
}
