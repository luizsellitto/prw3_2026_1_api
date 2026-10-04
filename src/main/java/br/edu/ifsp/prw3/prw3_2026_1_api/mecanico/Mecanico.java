package br.edu.ifsp.prw3.prw3_2026_1_api.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Embeddable: os campos do mecânico vão junto na tabela de consertos
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private Integer anosExperiencia;

    // passa os dados do record (DTO) pro objeto
    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosExperiencia = dados.anosExperiencia();
    }

    public void atualizarInformacoes(DadosMecanico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.anosExperiencia() != null) {
            this.anosExperiencia = dados.anosExperiencia();
        }
    }
}
