package br.edu.ifsp.prw3.prw3_2026_1_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
// pra paginação devolver um JSON estável (sem o warning do PageImpl), como visto na aula
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Prw320261ApiApplication {

	public static void main(String[] args) {
		// Avaliação 3 - PRW3
		// Dupla:
		//   Lucas Dalossa Lopes
		//   Luiz Augusto de Oliveira Sellitto

		SpringApplication.run(Prw320261ApiApplication.class, args);
	}

}
