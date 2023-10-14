package br.com.bbasset.investidor.api;

import br.com.bbasset.investidor.model.Investidor;

// POJO
public class InvestidorResponseDto {
    private String id;
    private String nome;
    private String cpf;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static InvestidorResponseDto converterParaInvestidorResponseDto(Investidor investidor) {
        InvestidorResponseDto investidorResponseDto = new InvestidorResponseDto();
        investidorResponseDto.setNome(investidor.getNome());
        investidorResponseDto.setCpf(investidor.getCpf());
        investidorResponseDto.setId(investidor.getId().toString());
        investidorResponseDto.setStatus(investidor.getStatus().name());
        return investidorResponseDto;
    }
}
