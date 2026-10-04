package br.edu.ifsp.prw3.prw3_2026_1_api.mecanico;

import jakarta.validation.constraints.NotBlank;

// DTO: dados do mecânico que chegam no JSON da requisição
public record DadosMecanico(

        @NotBlank
        String nome,

        Integer anosExperiencia) {  // opcional

}
