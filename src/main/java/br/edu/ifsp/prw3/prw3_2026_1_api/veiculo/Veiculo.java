package br.edu.ifsp.prw3.prw3_2026_1_api.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Embeddable: os campos do veículo vão junto na tabela de consertos
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    // passa os dados do record (DTO) pro objeto
    public Veiculo(DadosVeiculo dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
    }
}
