package com.api.astepi.controllers;


import com.api.astepi.dtos.AnaliseSocioEconomicaDto;
import com.api.astepi.dtos.DocumentoDto;
import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.DocumentoModel;
import com.api.astepi.services.AnaliseSocioEconomicaService;
import com.api.astepi.services.DocumentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/documentos")
public class DocumentoController {
    final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDocumento(@RequestBody @Valid DocumentoDto documentoDto){
        var documentoModel = new DocumentoModel();
        BeanUtils.copyProperties(documentoDto,documentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(documentoService.save(documentoModel));
    }

    @GetMapping("/download/{documentoId}")
    public ResponseEntity<byte[]> downloadDocumento(@PathVariable UUID documentoId) {
        DocumentoModel documento = documentoService.findByID(documentoId)
                .orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado"));

        byte[] arquivoBytes = documento.getArquivo();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(documento.getNome()).build());
        return new ResponseEntity<>(arquivoBytes, headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<DocumentoModel>> getAllDocumento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(documentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDocumento(@PathVariable (value = "id") UUID id){
        Optional<DocumentoModel> documentoModelOptional = documentoService.findByID(id);
        if(!documentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Documento not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(documentoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDocumento(@PathVariable (value = "id")UUID id){
        Optional<DocumentoModel> documentoModelOptional = documentoService.findByID(id);
        if(!documentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Documento not found.");
        }
        documentoService.delete(documentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Documento deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDocumento(@PathVariable(value = "id")UUID id,@RequestBody @Valid DocumentoDto documentoDto){
        Optional<DocumentoModel> documentoModelOptional = documentoService.findByID(id);
        if (!documentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Documento not found.");
        }
        var documentoModel = new DocumentoModel();
        BeanUtils.copyProperties(documentoDto, documentoModel);
        documentoModel.setId(documentoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(documentoService.save(documentoModel));
    }
    
}
