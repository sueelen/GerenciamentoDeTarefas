package com.example.gerenciamentodetarefas.controller.data.response;

import lombok.Builder;

@Builder
public class ErrorResponse {

	private Integer statusCode;
	private String descricao;
	
}
