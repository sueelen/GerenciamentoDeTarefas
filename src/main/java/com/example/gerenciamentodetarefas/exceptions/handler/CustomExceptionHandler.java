package com.example.gerenciamentodetarefas.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.gerenciamentodetarefas.controller.data.response.ErrorResponse;
import com.example.gerenciamentodetarefas.exceptions.DepartamentoNaoCompativelException;
import com.example.gerenciamentodetarefas.exceptions.PessoaNotFoundException;
import com.example.gerenciamentodetarefas.exceptions.TarefaNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(PessoaNotFoundException.class)
	public ResponseEntity<ErrorResponse> pessoaNotFoundHandler(PessoaNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.descricao("Pessoa não encontrada. ").build());
	}
	
	@ExceptionHandler(TarefaNotFoundException.class)
	public ResponseEntity<ErrorResponse> tarefaNotFoundHandler(TarefaNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.descricao("Tarefa não encontrada. ").build());
	}
	
	@ExceptionHandler(DepartamentoNaoCompativelException.class)
	public ResponseEntity<ErrorResponse> departamentoNaoCompativelHandler(DepartamentoNaoCompativelException e){
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(ErrorResponse.builder()
			.statusCode(HttpStatus.PRECONDITION_FAILED.value())
			.descricao("A pessoa informada não pertence ao departamento da tarefa. ").build());
	}
	
}