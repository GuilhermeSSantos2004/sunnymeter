package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.Producao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProducaoRepository extends JpaRepository<Producao, UUID> {
}
