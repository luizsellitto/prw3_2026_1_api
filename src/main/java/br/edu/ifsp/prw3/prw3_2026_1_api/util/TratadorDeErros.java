package br.edu.ifsp.prw3.prw3_2026_1_api.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Trata os erros de todos os controllers num lugar só
@RestControllerAdvice
public class TratadorDeErros {

    // registro não encontrado no banco -> 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {

        return ResponseEntity.notFound().build();
    }

    // erro de validação (@Valid) -> 400 com a lista de campos que deram erro
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {

        var erros = ex.getFieldErrors();

        // transforma cada erro do Spring no nosso record (campo + mensagem)
        var lista = erros.stream().map(DadosErroValidacao::new).toList();

        return ResponseEntity.badRequest().body(lista);
    }

    // DTO só pra montar a resposta do erro
    private record DadosErroValidacao(String campo, String msgErro) {

        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
