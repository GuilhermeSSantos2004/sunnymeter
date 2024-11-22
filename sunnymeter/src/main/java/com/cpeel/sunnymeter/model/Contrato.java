package com.cpeel.sunnymeter.model;

import jakarta.persistence.*; // Para Jakarta EE
// ou
// import javax.persistence.*; // Para Java EE (dependendo da versão)

import java.util.UUID;

@Entity
public class Contrato {

    @Id
    @GeneratedValue
    private UUID contratoUuid;

    @Column(nullable = false)
    private UUID clienteUuid;

    @Column(nullable = false)
    private UUID instalacaoUuid;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private boolean ativo;

    // Getters e Setters
    public UUID getContratoUuid() {
        return contratoUuid;
    }

    public void setContratoUuid(UUID contratoUuid) {
        this.contratoUuid = contratoUuid;
    }

    public UUID getClienteUuid() {
        return clienteUuid;
    }

    public void setClienteUuid(UUID clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

    public UUID getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(UUID instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
