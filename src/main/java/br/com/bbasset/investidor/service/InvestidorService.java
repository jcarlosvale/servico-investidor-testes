package br.com.bbasset.investidor.service;

import br.com.bbasset.investidor.exception.InvestidorJaExisteException;
import br.com.bbasset.investidor.model.Investidor;
import br.com.bbasset.investidor.repository.RepositorioInvestidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestidorService {

    private RepositorioInvestidor repositorioInvestidor;

    @Autowired
    public InvestidorService(RepositorioInvestidor repositorioInvestidor) {
        this.repositorioInvestidor = repositorioInvestidor;
    }

    public List<Investidor> listar() {
        return repositorioInvestidor.listar();
    }

    public void inserir(Investidor investidor) {
        Optional<Investidor> investidorOpt =
                repositorioInvestidor.buscarPorCpf(investidor.getCpf());
        if (investidorOpt.isEmpty()) {
            repositorioInvestidor.inserir(investidor);
        } else {
            throw new InvestidorJaExisteException(investidor.getCpf());
        }
    }
}
