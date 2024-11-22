package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
