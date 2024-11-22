package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Cliente;
import com.cpeel.sunnymeter.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.criar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable UUID id) {
        return ResponseEntity.ok(clienteService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable UUID id) {
        return ResponseEntity.ok(clienteService.deletar(id));
    }
}
