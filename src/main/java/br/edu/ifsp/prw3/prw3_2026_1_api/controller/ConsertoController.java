package br.edu.ifsp.prw3.prw3_2026_1_api.controller;

import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.Conserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.ConsertoRepository;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosCadastroConserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosListagemConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void cadastrar(@RequestBody @Valid DadosCadastroConserto dados) {

        // cria o conserto com os dados do JSON e grava no banco
        repository.save(new Conserto(dados));
    }

    // todos os dados, paginado (ex: /consertos?size=2&page=0)
    @GetMapping
    public Page<Conserto> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    // só datas, nome do mecânico, marca e modelo, sem paginação
    @GetMapping("algunsdados")
    public List<DadosListagemConserto> listarAlgunsDados() {

        // converte cada Conserto em DadosListagemConserto
        return repository.findAll().stream().map(DadosListagemConserto::new).toList();
    }
}
