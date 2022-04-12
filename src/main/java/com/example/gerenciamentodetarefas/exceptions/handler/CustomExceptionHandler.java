package com.example.gerenciamentodetarefas.exceptions.handler;

import java.util.stream.Collectors;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.gerenciamentodetarefas.controller.data.response.ErrorResponse;
import com.example.gerenciamentodetarefas.exceptions.DepartamentoNaoCompativelException;
import com.example.gerenciamentodetarefas.exceptions.DepartamentoNotFoundException;
import com.example.gerenciamentodetarefas.exceptions.PessoaNotFoundException;
import com.example.gerenciamentodetarefas.exceptions.TarefaNotFoundException;

@ControllerAdvice
@Order(10000)
public class CustomExceptionHandler {
	
	@ExceptionHandler(PessoaNotFoundException.class)
	public ResponseEntity<ErrorResponse> pessoaNotFoundHandler(PessoaNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.descricao("Pessoa não encontrada.").build());
	}
	
	@ExceptionHandler(TarefaNotFoundException.class)
	public ResponseEntity<ErrorResponse> tarefaNotFoundHandler(TarefaNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.descricao("Tarefa não encontrada.").build());
	}
	
	@ExceptionHandler(DepartamentoNotFoundException.class)
	public ResponseEntity<ErrorResponse> departamentoNotFoundHandler(DepartamentoNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.descricao("Departamento não encontrado.").build());
	}
	
	@ExceptionHandler(DepartamentoNaoCompativelException.class)
	public ResponseEntity<ErrorResponse> departamentoNaoCompativelHandler(DepartamentoNaoCompativelException e){
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(ErrorResponse.builder()
			.statusCode(HttpStatus.PRECONDITION_FAILED.value())
			.descricao(e.getMessage()).build());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidHandler(MethodArgumentNotValidException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.descricao(e.getAllErrors().get(0).getDefaultMessage()).build());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> runtimeExceptionHandler(RuntimeException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder()
			.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
			.descricao(e.getMessage()).build());
	}
	
}