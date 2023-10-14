package br.com.bbasset.investidor.repository;

public interface Inserivel<T> {
    void inserir(T entidade);
}
