package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.EnderecoModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/analises")
public class AnaliseSocioEconomicaController {
    private final AnaliseSocioEconomicaService analiseSocioEconomicaService;

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
        Optional<AnaliseSocioEconomicaModel> analiseSocioEconomicaModelOptional = analiseSocioEconomicaService.findByID(id);
        if(!analiseSocioEconomicaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnaliseSocioEconomica not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(analiseSocioEconomicaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnaliseSocioEconomica(@PathVariable (value = "id")UUID id){
        Optional<AnaliseSocioEconomicaModel> analiseSocioEconomicaModelOptional = analiseSocioEconomicaService.findByID(id);
        if(!analiseSocioEconomicaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnaliseSocioEconomica not found.");
        }
        analiseSocioEconomicaService.delete(analiseSocioEconomicaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("AnaliseSocioEconomica deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnaliseSec(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<String, Object> updates) {
        Optional<AnaliseSocioEconomicaModel> analiseSecOptional = analiseSocioEconomicaService.findByID(id);
        if (analiseSecOptional.isEmpty()) {
            throw new NotFoundException("Análise Socioeconômica not found.");
        }

        AnaliseSocioEconomicaModel analiseSec = analiseSecOptional.get();
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = AnaliseSocioEconomicaModel.class.getDeclaredField(key);
                field.setAccessible(true);
                field.set(analiseSec, value);
            } catch (NoSuchFieldException e) {
                return ResponseEntity.badRequest().body("Campo inválido: " + key);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        analiseSec.setId(id);
        analiseSocioEconomicaService.save(analiseSec);
        return ResponseEntity.status(HttpStatus.OK).body("Análise Socioeconômica atualizada com sucesso.");
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateAnaliseSocioEconomica(@PathVariable(value = "id")UUID id,@RequestBody @Valid AnaliseSocioEconomicaDto analiseSocioEconomicaDto){
//        Optional<AnaliseSocioEconomicaModel> analiseSocioEconomicaModelOptional = analiseSocioEconomicaService.finByID(id);
//        if (!analiseSocioEconomicaModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnaliseSocioEconomica not found.");
//        }
//        var analiseSocioEconomicaModel = new AnaliseSocioEconomicaModel();
//        BeanUtils.copyProperties(analiseSocioEconomicaDto, analiseSocioEconomicaModel);
//        analiseSocioEconomicaModel.setId(analiseSocioEconomicaModelOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(analiseSocioEconomicaService.save(analiseSocioEconomicaModel));
//    }
    
}
