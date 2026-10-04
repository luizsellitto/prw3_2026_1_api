package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.prw3_2026_1_api.mecanico.DadosMecanico;
import br.edu.ifsp.prw3.prw3_2026_1_api.veiculo.DadosVeiculo;

// DTO: o que chega no corpo (JSON) do POST.
// Os nomes têm que ser iguais aos do JSON!
public record DadosCadastroConserto(String dataEntrada,
                                    String dataSaida,
                                    DadosMecanico mecanico,
                                    DadosVeiculo veiculo) {
}
