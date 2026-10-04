package br.edu.ifsp.prw3.prw3_2026_1_api.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// DTO: dados do veículo que chegam no JSON da requisição
public record DadosVeiculo(

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        @Pattern(regexp = "\\d{4}")  // ano com 4 dígitos, ex: 2010
        String ano,

        String cor) {  // opcional

}
