package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.Producao;
import com.cpeel.sunnymeter.repository.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProducaoService {

    @Autowired
    private ProducaoRepository repository;

    public Producao save(Producao producao) {
        return repository.save(producao);
    }

    public List<Producao> findAll() {
        return repository.findAll();
    }

    public Optional<Producao> findById(UUID id) {
        return repository.findById(id);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
