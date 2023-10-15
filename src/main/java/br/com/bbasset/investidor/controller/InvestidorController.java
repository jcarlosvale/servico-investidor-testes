package br.com.bbasset.investidor.controller;

import br.com.bbasset.investidor.api.InvestidorRequestDto;
import br.com.bbasset.investidor.api.InvestidorResponseDto;
import br.com.bbasset.investidor.model.Investidor;
import br.com.bbasset.investidor.service.InvestidorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/investidores")
public class InvestidorController {

    private final InvestidorService investidorService;

    public InvestidorController(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvestidorResponseDto> listar() {
        List<Investidor> investidores = investidorService.listar();
        return investidores.stream()
                .map(Investidor::converterParaInvestidorResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvestidorResponseDto inserir(@RequestBody InvestidorRequestDto request) {
        Investidor investidor = request.converterParaInvestidor();
        investidor = investidorService.inserir(investidor);
        return investidor.converterParaInvestidorResponseDto();
    }
}
