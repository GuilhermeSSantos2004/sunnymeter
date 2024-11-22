package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Producao;
import com.cpeel.sunnymeter.service.ProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/producaos")
public class ProducaoController {

    @Autowired
    private ProducaoService service;

    @PostMapping
    public Producao create(@RequestBody Producao producao) {
        return service.save(producao);
    }

    @GetMapping
    public List<Producao> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producao> getById(@PathVariable UUID id) {
        Optional<Producao> producao = service.findById(id);
        return producao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
