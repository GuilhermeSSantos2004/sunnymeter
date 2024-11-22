package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.Instalacao;
import com.cpeel.sunnymeter.repository.InstalacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstalacaoService {

    private final InstalacaoRepository instalacaoRepository;

    public InstalacaoService(InstalacaoRepository instalacaoRepository) {
        this.instalacaoRepository = instalacaoRepository;
    }

    public Instalacao criarInstalacao(Instalacao instalacao) {
        instalacao.setAtivo(true); // Define como ativo ao criar
        return instalacaoRepository.save(instalacao);
    }

    public List<Instalacao> listarInstalacoes() {
        return instalacaoRepository.findAll();
    }

    public Optional<Instalacao> buscarInstalacao(UUID instalacaoUuid) {
        return instalacaoRepository.findById(instalacaoUuid);
    }

    public Instalacao deletarInstalacao(UUID instalacaoUuid) {
        Optional<Instalacao> instalacao = instalacaoRepository.findById(instalacaoUuid);
        if (instalacao.isPresent()) {
            Instalacao inst = instalacao.get();
            inst.setAtivo(false); // Realiza deleção lógica
            return instalacaoRepository.save(inst);
        }
        return null; // Retorna null se não encontrado
    }

    public Instalacao atualizarAtivo(UUID id, boolean ativo) {
        // Busca a instalação pelo ID
        Optional<Instalacao> optionalInstalacao = instalacaoRepository.findById(id);

        if (optionalInstalacao.isPresent()) {
            Instalacao instalacao = optionalInstalacao.get();
            instalacao.setAtivo(ativo); // Atualiza o status
            return instalacaoRepository.save(instalacao); // Salva no banco
        }

        throw new RuntimeException("Instalação não encontrada com ID: " + id);
    }
}
