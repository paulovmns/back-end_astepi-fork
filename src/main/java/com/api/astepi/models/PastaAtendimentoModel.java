package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PASTAATENDIMENTOMODEL")
public class PastaAtendimentoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    SecretariaModel secretariaModel;

    @Column(nullable = false, unique = true, length = 255)
    AdvogadoVoluntarioModel advogadoVoluntarioModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SecretariaModel getSecretariaModel() {
        return secretariaModel;
    }

    public void setSecretariaModel(SecretariaModel secretariaModel) {
        this.secretariaModel = secretariaModel;
    }

    public AdvogadoVoluntarioModel getAdvogadoVoluntarioModel() {
        return advogadoVoluntarioModel;
    }

    public void setAdvogadoVoluntarioModel(AdvogadoVoluntarioModel advogadoVoluntarioModel) {
        this.advogadoVoluntarioModel = advogadoVoluntarioModel;
    }

    public String receberDocumento() {
        String recebido = "N";
        if (recebido == "S") {
            return "+-+-+-+ DOCUMENTO RECEBIDO NA PASTA DE ATENDIMENTO +-+-+-+";
        } else {
            return "+-+-+-+ PASTA DE ATENDIMENTO SEM MODIFICAÇÃO +-+-+-+";
        }
    }

}
