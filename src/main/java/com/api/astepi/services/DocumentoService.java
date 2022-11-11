package com.api.astepi.services;

import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.DocumentoModel;
import com.api.astepi.repositories.AnaliseSocioEconomicaRepository;
import com.api.astepi.repositories.DocumentoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DocumentoService {
    final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository){
        this.documentoRepository = documentoRepository;
    }

    @Transactional
    public DocumentoModel save(DocumentoModel documentoModel) {
        return documentoRepository.save(documentoModel);
    }
}
