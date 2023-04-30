package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_DOCUMENTO")
public class DocumentoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, length = 255)
    private String nomeDoc;

    /*@ManyToOne
    @JoinColumn(name = "agendamento_documento_id")
    private AgendamentoModel agendamentoDocumento;*/



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public void setNomeDoc(String nomeDoc) {
        this.nomeDoc = nomeDoc;
    }

    /*public AgendamentoModel getAgendamentoDocumento() {
        return agendamentoDocumento;
    }

    public void setAgendamentoDocumento(AgendamentoModel agendamentoDocumento) {
        this.agendamentoDocumento = agendamentoDocumento;
    }*/
}
