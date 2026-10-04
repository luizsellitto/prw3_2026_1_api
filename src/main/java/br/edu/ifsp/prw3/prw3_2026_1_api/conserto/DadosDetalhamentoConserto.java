package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.prw3_2026_1_api.mecanico.Mecanico;
import br.edu.ifsp.prw3.prw3_2026_1_api.veiculo.Veiculo;

// DTO com todos os dados, usado nas respostas de cadastro, consulta e alteração.
public record DadosDetalhamentoConserto(Long id,
                                       String dataEntrada,
                                       String dataSaida,
                                       Mecanico mecanico,
                                       Veiculo veiculo,
                                       Boolean ativo) {

    public DadosDetalhamentoConserto(Conserto conserto) {
        this(conserto.getId(),
             conserto.getDataEntrada(),
             conserto.getDataSaida(),
             conserto.getMecanico(),
             conserto.getVeiculo(),
             conserto.getAtivo());
    }
}
