package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.AnaliseSocioEconomicaService;
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
@RequestMapping("/analisesocioeconomicas")
public class AnaliseSocioEconomicaController {
    final AnaliseSocioEconomicaService analiseSocioEconomicaService;

    public AnaliseSocioEconomicaController(AnaliseSocioEconomicaService analiseSocioEconomicaService) {
        this.analiseSocioEconomicaService = analiseSocioEconomicaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAnaliseSocioEconomica(@RequestBody @Valid AnaliseSocioEconomicaDto analiseSocioEconomicaDto){
        var analiseSocioEconomicaModel = new AnaliseSocioEconomicaModel();
        BeanUtils.copyProperties(analiseSocioEconomicaDto,analiseSocioEconomicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(analiseSocioEconomicaService.save(analiseSocioEconomicaModel));
    }

    @GetMapping
    public ResponseEntity<Page<AnaliseSocioEconomicaModel>> getAllAnaliseSocioEconomica(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(analiseSocioEconomicaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAnaliseSocioEconomica(@PathVariable (value = "id") UUID id){
        Optional<AnaliseSocioEconomicaModel> analiseSocioEconomicaModelOptional = analiseSocioEconomicaService.finByID(id);
        if(!analiseSocioEconomicaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnaliseSocioEconomica not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(analiseSocioEconomicaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnaliseSocioEconomica(@PathVariable (value = "id")UUID id){
        Optional<AnaliseSocioEconomicaModel> analiseSocioEconomicaModelOptional = analiseSocioEconomicaService.finByID(id);
        if(!analiseSocioEconomicaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnaliseSocioEconomica not found.");
        }
        analiseSocioEconomicaService.delete(analiseSocioEconomicaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("AnaliseSocioEconomica deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnaliseSocioEconomica(@PathVariable(value = "id")UUID id,@RequestBody @Valid AnaliseSocioEconomicaDto analiseSocioEconomicaDto){
        Optional<AnaliseSocioEconomicaModel> analiseSocioEconomicaModelOptional = analiseSocioEconomicaService.finByID(id);
        if (!analiseSocioEconomicaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnaliseSocioEconomica not found.");
        }
        var analiseSocioEconomicaModel = new AnaliseSocioEconomicaModel();
        BeanUtils.copyProperties(analiseSocioEconomicaDto, analiseSocioEconomicaModel);
        analiseSocioEconomicaModel.setId(analiseSocioEconomicaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(analiseSocioEconomicaService.save(analiseSocioEconomicaModel));
    }
    
}
