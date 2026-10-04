package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

import br.edu.ifsp.prw3.prw3_2026_1_api.mecanico.Mecanico;
import br.edu.ifsp.prw3.prw3_2026_1_api.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // datas podem ser só String (pedido no enunciado)
    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    // monta o conserto a partir do DTO que veio na requisição
    public Conserto(DadosCadastroConserto dados) {
        this.ativo = true;
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }
        if (dados.mecanico() != null) {
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
