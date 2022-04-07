package com.example.gerenciamentodetarefas.services;

import com.example.gerenciamentodetarefas.entities.Pessoa;

public interface PessoaService {
	Pessoa salvar(Pessoa pessoa);
	void deletar(Long id);
	
}
