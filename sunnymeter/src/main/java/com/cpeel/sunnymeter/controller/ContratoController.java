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

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable UUID id) {
        Optional<Contrato> contrato = contratoService.buscarContrato(id);
        return contrato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contrato> deletarContrato(@PathVariable UUID id) {
        Contrato deletado = contratoService.deletarContrato(id);
        if (deletado != null) {
            return ResponseEntity.ok(deletado);
        }
        return ResponseEntity.notFound().build();
    }
}
