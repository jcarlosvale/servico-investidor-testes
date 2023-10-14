package br.com.bbasset.investidor.controller;

import br.com.bbasset.investidor.api.ErroResponseDto;
import br.com.bbasset.investidor.exception.InvestidorJaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvestidorControllerAdvice {

    @ExceptionHandler(InvestidorJaExisteException.class)
    public ResponseEntity<ErroResponseDto> handleInvestidorJaExisteException(
            InvestidorJaExisteException ex
    ) {
        ErroResponseDto erroResponseDto = new ErroResponseDto();
        erroResponseDto.setMensagem(ex.getMessage());
        return new ResponseEntity<>(erroResponseDto, HttpStatus.CONFLICT);
    }
}
