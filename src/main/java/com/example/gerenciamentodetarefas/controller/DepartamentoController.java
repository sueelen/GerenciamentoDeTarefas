package com.example.gerenciamentodetarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gerenciamentodetarefas.entities.Departamento;
import com.example.gerenciamentodetarefas.services.DepartamentoService;
import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	private final DepartamentoService departamentoService;
	
	@GetMapping("")
	public ResponseEntity<List<Departamento>> listarDepartamentos(){
		return ResponseEntity.ok(departamentoService.listarDepartamentos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> consultarDepartamento(@PathVariable Integer id){
		return ResponseEntity.ok(departamentoService.consultarDepartamento(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Departamento> salvar(@RequestBody(required = true) @Valid Departamento departamento){
		return ResponseEntity.ok(departamentoService.salvar(departamento));
	}
}
