package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Instalacao;
import com.cpeel.sunnymeter.service.InstalacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {

    private final InstalacaoService instalacaoService;

    public InstalacaoController(InstalacaoService instalacaoService) {
        this.instalacaoService = instalacaoService;
    }

    @PostMapping
    public ResponseEntity<Instalacao> criarInstalacao(@RequestBody Instalacao instalacao) {
        Instalacao novaInstalacao = instalacaoService.criarInstalacao(instalacao);
        return ResponseEntity.ok(novaInstalacao);
    }

    @GetMapping
    public ResponseEntity<List<Instalacao>> listarInstalacoes() {
        return ResponseEntity.ok(instalacaoService.listarInstalacoes());
    }

    @GetMapping("/{instalacaoUuid}")
    public ResponseEntity<Instalacao> buscarInstalacao(@PathVariable UUID instalacaoUuid) {
        Optional<Instalacao> instalacao = instalacaoService.buscarInstalacao(instalacaoUuid);
        return instalacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{instalacaoUuid}")
    public ResponseEntity<Instalacao> deletarInstalacao(@PathVariable UUID instalacaoUuid) {
        Instalacao deletada = instalacaoService.deletarInstalacao(instalacaoUuid);
        if (deletada != null) {
            return ResponseEntity.ok(deletada);
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/{id}")

    public ResponseEntity<Instalacao> atualizarAtivo(@PathVariable UUID id, @RequestBody Map<String, Boolean> atualizacao) {

      boolean ativo = atualizacao.get("ativo");

      return ResponseEntity.ok(instalacaoService.atualizarAtivo(id, ativo));

    }
}
