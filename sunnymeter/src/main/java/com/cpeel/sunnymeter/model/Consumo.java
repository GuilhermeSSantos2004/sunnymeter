package com.cpeel.sunnymeter.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID consumoUuid;

    // Adicione os campos necessários aqui
}
