package br.com.bbasset.investidor.repository;

import br.com.bbasset.investidor.model.Investidor;

public interface Inserivel<T> {
    Investidor inserir(T entidade);
}
