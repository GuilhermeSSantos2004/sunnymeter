package com.cpeel.sunnymeter.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Contrato {
    @Id
    @GeneratedValue
    private UUID contratoUuid;

    private UUID clienteUuid;
    private UUID instalacaoUuid;
    private LocalDate dataInicio;
    private int duracaoDias;
    private boolean ativo = true;

    // Getters e Setters
}
