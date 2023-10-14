package br.com.bbasset.investidor.repository;

import br.com.bbasset.investidor.model.Investidor;

import java.util.Optional;


public interface RepositorioInvestidor extends Listavel<Investidor>, Inserivel<Investidor> {
    Optional<Investidor> buscarPorCpf(String cpf);
}
