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
        return contratoRepository.save(contrato);
    }

    public Optional<Contrato> buscarContrato(UUID id) {
        return contratoRepository.findById(id);
    }

    public Contrato deletarContrato(UUID id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);
        if (contrato.isPresent()) {
            Contrato c = contrato.get();
            c.setAtivo(false);
            return contratoRepository.save(c);
        }
        return null;
    }
}
