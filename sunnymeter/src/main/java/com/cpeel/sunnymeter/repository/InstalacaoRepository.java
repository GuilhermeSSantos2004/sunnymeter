package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.Instalacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InstalacaoRepository extends JpaRepository<Instalacao, UUID> {
}
