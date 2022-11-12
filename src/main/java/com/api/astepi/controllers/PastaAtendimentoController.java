package com.api.astepi.controllers;


import com.api.astepi.dtos.EnderecoDto;
import com.api.astepi.dtos.PastaAtendimentoDto;
import com.api.astepi.models.EnderecoModel;
import com.api.astepi.models.PastaAtendimentoModel;
import com.api.astepi.services.EnderecoService;
import com.api.astepi.services.PastaAtendimentoService;
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
@RequestMapping("/pastaatendimentos")
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

    @GetMapping
    public ResponseEntity<Page<PastaAtendimentoModel>> getAllPastaAtendimento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pastaAtendimentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePastaAtendimento(@PathVariable (value = "id") UUID id){
        Optional<PastaAtendimentoModel> pastaAtendimentoModelOptional = pastaAtendimentoService.finByID(id);
        if(!pastaAtendimentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PastaAtendimento not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pastaAtendimentoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePastaAtendimento(@PathVariable (value = "id")UUID id){
        Optional<PastaAtendimentoModel> pastaAtendimentoModelOptional = pastaAtendimentoService.finByID(id);
        if(!pastaAtendimentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PastaAtendimento not found.");
        }
        pastaAtendimentoService.delete(pastaAtendimentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("PastaAtendimento deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePastaAtendimento(@PathVariable(value = "id")UUID id,@RequestBody @Valid PastaAtendimentoDto pastaAtendimentoDto){
        Optional<PastaAtendimentoModel> pastaAtendimentoModelOptional = pastaAtendimentoService.finByID(id);
        if (!pastaAtendimentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PastaAtendimento not found.");
        }
        var pastaAtendimentoModel = new PastaAtendimentoModel();
        BeanUtils.copyProperties(pastaAtendimentoDto, pastaAtendimentoModel);
        pastaAtendimentoModel.setId(pastaAtendimentoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pastaAtendimentoService.save(pastaAtendimentoModel));
    }
    
}
