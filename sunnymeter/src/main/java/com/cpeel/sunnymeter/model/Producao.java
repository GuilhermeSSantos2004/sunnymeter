package com.cpeel.sunnymeter.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID producaoUuid;

    // Adicione os campos necessários aqui
}
