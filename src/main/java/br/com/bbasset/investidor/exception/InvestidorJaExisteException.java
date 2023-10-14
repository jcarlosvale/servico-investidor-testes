package br.com.bbasset.investidor.exception;

public class InvestidorJaExisteException extends RuntimeException {

    public InvestidorJaExisteException(String cpf) {
        super("O CPF informado já existe - " + cpf);
    }
}
