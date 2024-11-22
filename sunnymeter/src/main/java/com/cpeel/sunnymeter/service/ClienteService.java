package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.Cliente;
import com.cpeel.sunnymeter.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscar(UUID id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente deletar(UUID id) {
        Cliente cliente = buscar(id);
        cliente.setAtivo(false);
        return clienteRepository.save(cliente);
    }

    // Método para atualizar o status "ativo"
    public Cliente atualizarAtivo(UUID id, boolean ativo) {
    Cliente cliente = buscar(id); // Busca o cliente existente
    cliente.setAtivo(ativo);      // Atualiza o campo "ativo"
    return clienteRepository.save(cliente); // Salva no banco de dados
    }
}
