package com.example.gerenciamentodetarefas.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gerenciamentodetarefas.entities.Tarefa;
import com.example.gerenciamentodetarefas.services.TarefaService;
import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	private final TarefaService tarefaService;
	
	@PutMapping("/finalizar/{id}")
	public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id){
		return ResponseEntity.ok(tarefaService.finalizar(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Tarefa> salvar(@RequestBody(required = true) @Valid Tarefa tarefa){
		return ResponseEntity.ok(tarefaService.salvar(tarefa));
	}
	
	@PutMapping("{idTarefa}/alocar/{idPessoa}")
	public ResponseEntity<Tarefa> alocarPessoa(@PathVariable Long idTarefa, @PathVariable Long idPessoa){
		return ResponseEntity.ok(tarefaService.alocarPessoa(idTarefa, idPessoa));
	}
	
	@GetMapping("/pendentes")
	public ResponseEntity<List<Tarefa>> consultarMaisAntigasSemPessoaAlocada(){
		return ResponseEntity.ok(tarefaService.consultarMaisAntigasSemPessoaAlocada(3));
	}
	

}
