package com.example.gerenciamentodetarefas.controller.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private Integer statusCode;
	private String descricao;
	
}
