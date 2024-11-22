package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.Consumo;
import com.cpeel.sunnymeter.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    public Consumo save(Consumo consumo) {
        return repository.save(consumo);
    }

    public List<Consumo> findAll() {
        return repository.findAll();
    }

    public Optional<Consumo> findById(UUID id) {
        return repository.findById(id);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
