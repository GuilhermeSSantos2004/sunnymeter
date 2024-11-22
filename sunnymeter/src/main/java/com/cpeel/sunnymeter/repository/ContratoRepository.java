package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
}
