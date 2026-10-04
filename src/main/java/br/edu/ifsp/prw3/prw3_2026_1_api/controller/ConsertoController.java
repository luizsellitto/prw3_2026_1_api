package br.edu.ifsp.prw3.prw3_2026_1_api.controller;

import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.Conserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.ConsertoRepository;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosCadastroConserto;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    // injeção de dependência pelo construtor (o Spring passa o repository pra gente)
    private final ConsertoRepository repository;

    public ConsertoController(ConsertoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConserto dados) {

        // cria o conserto com os dados do JSON e grava no banco
        repository.save(new Conserto(dados));
    }
}
