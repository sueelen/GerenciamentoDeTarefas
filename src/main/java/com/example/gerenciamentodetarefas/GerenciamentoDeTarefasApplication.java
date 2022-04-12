package com.example.gerenciamentodetarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gerenciamento de Tarefas", version = "1.0", description = "API de Gerenciamento de Tarefas"))
public class GerenciamentoDeTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoDeTarefasApplication.class, args);
	}

}
