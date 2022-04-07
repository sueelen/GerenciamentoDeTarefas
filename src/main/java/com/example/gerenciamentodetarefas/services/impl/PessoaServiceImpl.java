package com.example.gerenciamentodetarefas.services.impl;

import org.springframework.stereotype.Component;

import com.example.gerenciamentodetarefas.entities.Pessoa;
import com.example.gerenciamentodetarefas.repositories.PessoaRepository;
import com.example.gerenciamentodetarefas.services.PessoaService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {
	
    private final PessoaRepository pessoaRepository;

	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}
	 
}
