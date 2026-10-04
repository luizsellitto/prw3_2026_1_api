package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.prw3_2026_1_api.mecanico.DadosMecanico;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Só os campos permitidos na alteração; os que não vierem ficam como estão.
public record DadosAtualizacaoConserto(

        @NotNull
        Long id,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        DadosMecanico mecanico) {

}
