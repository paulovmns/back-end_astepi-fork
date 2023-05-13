package com.api.astepi.services;

import com.api.astepi.models.AnaliseSocioEconomicaModel;
import com.api.astepi.models.DocumentoModel;
import com.api.astepi.repositories.AnaliseSocioEconomicaRepository;
import com.api.astepi.repositories.DocumentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentoService {
    final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository){
        this.documentoRepository = documentoRepository;
    }


//    public void salvarDocumento(MultipartFile arquivo, String nome) throws IOException {
//        DocumentoModel documento = new DocumentoModel();
//        documento.setNome(nome);
//        documento.setArquivo(arquivo.getBytes());
//        documentoRepository.save(documento);
//    }

    @Transactional
    public DocumentoModel save(DocumentoModel documentoModel) {
        return documentoRepository.save(documentoModel);
    }

    public Page<DocumentoModel> findAll(Pageable pageable){
        return documentoRepository.findAll(pageable);
    }

    public Optional<DocumentoModel> findByID(UUID id) {
        return documentoRepository.findById(id);
    }

    @Transactional
    public void delete(DocumentoModel documentoModel) {
        documentoRepository.delete(documentoModel);
    }

}
