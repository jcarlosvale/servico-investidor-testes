package br.com.bbasset.investidor.api;

import br.com.bbasset.investidor.model.Investidor;
import br.com.bbasset.investidor.model.StatusInvestidor;

import java.util.UUID;

public class InserirInvestidorRequestDto {
    private String nome;
    private String cpf;

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

    public Investidor converterParaInvestidor() {
        Investidor investidor = new Investidor();
        investidor.setNome(this.getNome());
        investidor.setCpf(this.getCpf());
        investidor.setStatus(StatusInvestidor.ATIVO);
        investidor.setId(UUID.randomUUID());
        return investidor;
    }
}