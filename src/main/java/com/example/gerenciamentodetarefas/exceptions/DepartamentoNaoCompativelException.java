package com.example.gerenciamentodetarefas.exceptions;

public class DepartamentoNaoCompativelException extends RuntimeException {
	public DepartamentoNaoCompativelException(String message) {
		super(message);
	}
}
