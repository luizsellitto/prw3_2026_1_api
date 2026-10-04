package br.edu.ifsp.prw3.prw3_2026_1_api.controller;

import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.Conserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.ConsertoRepository;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosAtualizacaoConserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosCadastroConserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosDetalhamentoConserto;
import br.edu.ifsp.prw3.prw3_2026_1_api.conserto.DadosListagemConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<DadosDetalhamentoConserto> cadastrar(
            @RequestBody @Valid DadosCadastroConserto dados, UriComponentsBuilder uriBuilder) {

        // cria o conserto com os dados do JSON e grava no banco
        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    // todos os dados, paginado (ex: /consertos?size=2&page=0)
    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoConserto>> listar(Pageable paginacao) {
        var pagina = repository.findAll(paginacao).map(DadosDetalhamentoConserto::new);

        return ResponseEntity.ok(pagina);
    }

    // só ID, datas, nome do mecânico, marca e modelo dos ativos, sem paginação
    @GetMapping("algunsdados")
    public ResponseEntity<List<DadosListagemConserto>> listarAlgunsDados() {

        // converte cada Conserto em DadosListagemConserto
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoConserto> getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConserto> atualizar(
            @RequestBody @Valid DadosAtualizacaoConserto dados) {

        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        // A JPA grava a alteração automaticamente no fim da transação.
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();
    }
}
