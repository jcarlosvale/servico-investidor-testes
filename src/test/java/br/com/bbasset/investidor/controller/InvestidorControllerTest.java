package br.com.bbasset.investidor.controller;

import br.com.bbasset.investidor.api.InvestidorRequestDto;
import br.com.bbasset.investidor.api.InvestidorResponseDto;
import br.com.bbasset.investidor.model.Investidor;
import br.com.bbasset.investidor.service.InvestidorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class InvestidorControllerTest {

    @Mock
    private InvestidorService service;

    @Mock
    private Investidor investidorOne;

    @Mock
    private Investidor investidorTwo;

    @Mock
    private InvestidorResponseDto responseOne;

    @Mock
    private InvestidorResponseDto responseTwo;

    @Mock
    private InvestidorRequestDto request;

    @InjectMocks
    private InvestidorController controller;

    @Test
    void listarTest() {
        // given
        var listOfInvestidores = List.of(investidorOne, investidorTwo);
        var exprected = List.of(responseOne, responseTwo);

        given(service.listar())
                .willReturn(listOfInvestidores);
        given(investidorOne.converterParaInvestidorResponseDto())
                .willReturn(responseOne);
        given(investidorTwo.converterParaInvestidorResponseDto())
                .willReturn(responseTwo);

        // when
        var actual = controller.listar();

        // then
        assertEquals(exprected, actual);
    }

    @Test
    void inserirTest() {
        // given
        given(request.converterParaInvestidor())
                .willReturn(investidorOne);
        given(service.inserir(investidorOne))
                .willReturn(investidorOne);
        given(investidorOne.converterParaInvestidorResponseDto())
                .willReturn(responseOne);

        // when
        var actual = controller.inserir(request);

        // then
        assertEquals(responseOne, actual);

    }
}