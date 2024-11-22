package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Consumo;
import com.cpeel.sunnymeter.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {

    @Autowired
    private ConsumoService service;

    @PostMapping
    public Consumo create(@RequestBody Consumo consumo) {
        return service.save(consumo);
    }

    @GetMapping
    public List<Consumo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumo> getById(@PathVariable UUID id) {
        Optional<Consumo> consumo = service.findById(id);
        return consumo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
