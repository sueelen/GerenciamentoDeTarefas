package com.example.gerenciamentodetarefas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.example.gerenciamentodetarefas.entities.Departamento;
import com.example.gerenciamentodetarefas.repositories.DepartamentoRepository;
import com.example.gerenciamentodetarefas.services.DepartamentoService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {
	
	private final DepartamentoRepository departamentoRepository;

	@Override
	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}

	@Override
	public Departamento consultarDepartamento(Integer idDepartamento) {
		Optional<Departamento> departamentoOpt = departamentoRepository.findById(idDepartamento);
		return departamentoOpt.isPresent() ? departamentoOpt.get() : null;
	}

	@Override
	public Departamento salvar(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
}
