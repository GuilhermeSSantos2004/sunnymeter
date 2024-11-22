package com.cpeel.sunnymeter.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private UUID clienteUuid;

    private String nome;
    private String endereco;
    private String documento;
    private String tipo;
    private String cep;
    private boolean ativo = true;

    // Getters e Setters
    public UUID getClienteUuid() {
        return clienteUuid;
    }

    public void setClienteUuid(UUID clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
