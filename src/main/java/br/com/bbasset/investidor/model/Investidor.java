package br.com.bbasset.investidor.model;

import java.util.UUID;

public class Investidor {
    private UUID id;
    private String nome;
    private String cpf;
    private StatusInvestidor status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusInvestidor getStatus() {
        return status;
    }

    public void setStatus(StatusInvestidor status) {
        this.status = status;
    }
}
