package com.example.gerenciamentodetarefas.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.gerenciamentodetarefas.controller.converter.PessoaResponseConverter;
import com.example.gerenciamentodetarefas.controller.data.response.PessoaGastosResponse;
import com.example.gerenciamentodetarefas.controller.data.response.PessoaResponse;
import com.example.gerenciamentodetarefas.entities.Pessoa;
import com.example.gerenciamentodetarefas.services.PessoaService;
import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	private final PessoaService pessoaService;
	private final PessoaResponseConverter pessoaResponseConverter;
	
	@PostMapping("")
	public ResponseEntity<Pessoa> salvar(@RequestBody(required = true) @Valid Pessoa pessoa){
		return ResponseEntity.ok(pessoaService.salvar(pessoa));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		pessoaService.deletar(id);
		return ResponseEntity.ok("Pessoa deletada com sucesso!");
	}
	
	@GetMapping("")
	public ResponseEntity<List<PessoaResponse>> listarPessoas(){
		return ResponseEntity.ok(pessoaResponseConverter.convertToPessoaResponseList(pessoaService.listarPessoas()));
	}
	
	@GetMapping("/gastos")
	public ResponseEntity<List<PessoaGastosResponse>> consultarMediaHorasGastasPorNomeEPeriodo(
		@RequestParam(required = true) @NotBlank(message = "O campo nome deve ser preenchido!") @Valid String nome,
		@RequestParam(required = true) @NotNull(message = "O campo dataInicial deve ser preenchido!") @Valid LocalDate dataInicial,
		@RequestParam(required = true) @NotNull(message = "O campo dataFim deve ser preenchido!") @Valid LocalDate dataFim){
		return ResponseEntity.ok(pessoaResponseConverter.convertToPessoaGastosResponseList(pessoaService.consultarPessoasPorNome(nome), dataInicial, dataFim));
	}
	
}
