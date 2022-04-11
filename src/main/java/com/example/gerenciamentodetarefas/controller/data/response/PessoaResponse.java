package com.example.gerenciamentodetarefas.controller.data.response;

import lombok.Builder;

@Builder
public class PessoaResponse {
	
	private String nome;
	private String departamento;
	private Long totalHorasGastasTarefas;

}
