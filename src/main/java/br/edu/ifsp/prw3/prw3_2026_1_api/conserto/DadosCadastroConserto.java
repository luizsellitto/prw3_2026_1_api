package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.prw3_2026_1_api.mecanico.DadosMecanico;
import br.edu.ifsp.prw3.prw3_2026_1_api.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// DTO: o que chega no corpo (JSON) do POST.
// Os nomes têm que ser iguais aos do JSON!
public record DadosCadastroConserto(

        // só confere o formato xx/xx/xxxx (não valida se o dia/mês existe)
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        @NotNull
        @Valid  // pra validar também o que tem dentro do DadosMecanico
        DadosMecanico mecanico,

        @NotNull
        @Valid  // pra validar também o que tem dentro do DadosVeiculo
        DadosVeiculo veiculo) {

}
