package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.Contrato;
import com.cpeel.sunnymeter.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public Contrato criarContrato(Contrato contrato) {
        contrato.setAtivo(true);
        contrato.setDataInicio(System.currentTimeMillis());
        return contratoRepository.save(contrato);
    }

    public Optional<Contrato> buscarContrato(UUID contratoUuid) {
        return contratoRepository.findById(contratoUuid);
    }

    public Contrato deletarContrato(UUID contratoUuid) {
        return contratoRepository.findById(contratoUuid)
            .map(contrato -> {
                contrato.setAtivo(false);
                return contratoRepository.save(contrato);
            })
            .orElse(null);
    }
}
