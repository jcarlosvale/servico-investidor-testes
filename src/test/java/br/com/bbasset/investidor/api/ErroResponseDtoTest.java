package br.com.bbasset.investidor.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErroResponseDtoTest {

    private final ErroResponseDto erroResponseDto = new ErroResponseDto();

    @Test
    void propertiesTest() {
        // given
        var expected = "some message";
        erroResponseDto.setMensagem(expected);

        // when
        var actual = erroResponseDto.getMensagem();

        // then
        assertEquals(expected, actual);
    }

}