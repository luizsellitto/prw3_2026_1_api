package br.edu.ifsp.prw3.prw3_2026_1_api.veiculo;

// DTO: dados do veículo que chegam no JSON da requisição
public record DadosVeiculo(String marca, String modelo, String ano) {
}
