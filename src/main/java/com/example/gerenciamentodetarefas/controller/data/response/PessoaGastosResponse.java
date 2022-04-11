package com.example.gerenciamentodetarefas.controller.data.response;

import lombok.Builder;

@Builder
public class PessoaGastosResponse {
	
	private String nome;
	private Double mediaHorasGastasTarefas;

}
