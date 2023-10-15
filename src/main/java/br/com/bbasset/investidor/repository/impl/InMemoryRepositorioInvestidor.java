package br.com.bbasset.investidor.repository.impl;

import br.com.bbasset.investidor.model.Investidor;
import br.com.bbasset.investidor.repository.RepositorioInvestidor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryRepositorioInvestidor implements RepositorioInvestidor {

    private List<Investidor> investidores = new ArrayList<>();

    @Override
    public List<Investidor> listar() {
        return investidores;
    }

    @Override
    public Investidor inserir(Investidor entidade) {
        investidores.add(entidade);
        return entidade;
    }

    @Override
    public Optional<Investidor> buscarPorCpf(String cpf) {
        return investidores.stream()
                .filter(investidor -> investidor.getCpf().equals(cpf))
                .findFirst();
    }
}
