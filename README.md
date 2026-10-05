# API de Consertos - PRW3

Projeto desenvolvido em dupla para a disciplina de **Programação para Web III (PRW3)**.

A aplicação é uma API REST em Java com Spring Boot para cadastrar, consultar, atualizar e realizar a exclusão lógica de consertos de veículos.

## Integrantes

- Lucas Dalossa Lopes
- Luiz Augusto de Oliveira Sellitto

## Swagger (testar a API pelo navegador)

O projeto tem o Swagger, uma página que lista todas as rotas da API e permite testar cada uma sem precisar do Postman.

1. Rode a aplicação (classe `Prw320261ApiApplication`).
2. Com ela rodando, abra no navegador: http://localhost:8080/swagger-ui.html
3. Clique na rota que quer testar e depois em **Try it out**.
4. Preencha os dados (o JSON do corpo ou o `id` na URL) e clique em **Execute**.
5. Logo abaixo aparecem o código de status e a resposta da API.

Exemplo de JSON para o `POST /consertos`:

```json
{
  "dataEntrada": "01/10/2026",
  "dataSaida": "03/10/2026",
  "mecanico": { "nome": "Joao Silva", "anosExperiencia": 8 },
  "veiculo": { "marca": "Fiat", "modelo": "Uno", "ano": "2010", "cor": "Prata" }
}
```
