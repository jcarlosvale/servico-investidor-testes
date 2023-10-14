package br.com.bbasset.investidor.controller;

import br.com.bbasset.investidor.api.InserirInvestidorRequestDto;
import br.com.bbasset.investidor.api.InvestidorResponseDto;
import br.com.bbasset.investidor.model.Investidor;
import br.com.bbasset.investidor.service.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/investidores")
public class InvestidorController {

    private InvestidorService investidorService;

    @Autowired
    public InvestidorController(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvestidorResponseDto> listar() {
        List<Investidor> investidores = investidorService.listar();
        // Function<T = Investidor, R = InvestidorResponseDto>
        return investidores.stream()
//                .map(investidor -> InvestidorResponseDto.converterParaInvestidorResponseDto(investidor))
                .map(InvestidorResponseDto::converterParaInvestidorResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvestidorResponseDto inserir(@RequestBody InserirInvestidorRequestDto request) {
        Investidor investidor = request.converterParaInvestidor();
        investidorService.inserir(investidor);
        return InvestidorResponseDto.converterParaInvestidorResponseDto(investidor);
    }
}
