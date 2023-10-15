package br.com.bbasset.investidor.api;

import br.com.bbasset.investidor.model.StatusInvestidor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InvestidorRequestDtoTest {

    private final InvestidorRequestDto dto = new InvestidorRequestDto();

    @Test
    void propertiesTest() {
        // given
        String expectedNome = "some nome";
        String expectedCpf = "some cpf";

        // when
        dto.setNome(expectedNome);
        dto.setCpf(expectedCpf);

        // then
        assertEquals(expectedNome, dto.getNome());
        assertEquals(expectedCpf, dto.getCpf());
    }

    @Test
    void converterParaInvestidorTest() {
        // given
        String expectedNome = "some nome";
        String expectedCpf = "some cpf";
        StatusInvestidor expectedStatus = StatusInvestidor.ATIVO;

        dto.setNome(expectedNome);
        dto.setCpf(expectedCpf);

        // when
        var actual = dto.converterParaInvestidor();

        // then
        assertNotNull(actual.getId());
        assertEquals(actual.getNome(), expectedNome);
        assertEquals(actual.getCpf(), expectedCpf);
        assertEquals(actual.getStatus(), expectedStatus);
    }
}