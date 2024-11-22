package com.cpeel.sunnymeter.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue
    private UUID contratoUuid;

    @Column(nullable = false)
    private UUID clienteUuid;

    @Column(nullable = false)
    private UUID instalacaoUuid;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false)
    private long dataInicio;
}
