package com.cpeel.sunnymeter.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Instalacao {
    @Id
    @GeneratedValue
    private UUID instalacaoUuid;

    private String endereco;
    private String cep;
    private boolean ativo = true;

    // Getters e Setters
}
