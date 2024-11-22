package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Contrato;
import com.cpeel.sunnymeter.service.ContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<Contrato> criarContrato(@RequestBody Contrato contrato) {
        return ResponseEntity.ok(contratoService.criarContrato(contrato));
    }

    @GetMapping("/{contratoUuid}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable UUID contratoUuid) {
        Optional<Contrato> contrato = contratoService.buscarContrato(contratoUuid);
        return contrato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{contratoUuid}")
    public ResponseEntity<Contrato> deletarContrato(@PathVariable UUID contratoUuid) {
        Contrato contrato = contratoService.deletarContrato(contratoUuid);
        if (contrato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrato);
    }
}
