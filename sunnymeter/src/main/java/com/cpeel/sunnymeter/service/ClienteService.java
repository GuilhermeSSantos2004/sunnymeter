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
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente deletar(UUID id) {
        Cliente cliente = buscar(id);
        if (cliente != null) {
            cliente.setAtivo(false);
            return clienteRepository.save(cliente);
        }
        return null;
    }
}
