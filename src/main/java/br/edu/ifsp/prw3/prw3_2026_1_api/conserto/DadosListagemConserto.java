package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

// DTO de saída: só os dados que a listagem resumida devolve
public record DadosListagemConserto(Long id,
                                    String dataEntrada,
                                    String dataSaida,
                                    String nomeMecanico,
                                    String marca,
                                    String modelo) {

    // recebe um Conserto e pega só o que interessa (tem que chamar o this)
    public DadosListagemConserto(Conserto conserto) {
        this(conserto.getId(),
             conserto.getDataEntrada(),
             conserto.getDataSaida(),
             conserto.getMecanico().getNome(),
             conserto.getVeiculo().getMarca(),
             conserto.getVeiculo().getModelo());
    }
}
