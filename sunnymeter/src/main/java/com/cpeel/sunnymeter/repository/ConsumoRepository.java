package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ConsumoRepository extends JpaRepository<Consumo, UUID> {
}
