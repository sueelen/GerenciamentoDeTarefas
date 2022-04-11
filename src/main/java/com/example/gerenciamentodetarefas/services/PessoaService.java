package com.example.gerenciamentodetarefas.services;

import java.util.List;
import com.example.gerenciamentodetarefas.entities.Pessoa;

public interface PessoaService {
	Pessoa salvar(Pessoa pessoa);
	void deletar(Long id);
	Pessoa consultarPessoa(Long id);
	List<Pessoa> listarPessoas();
	List<Pessoa> consultarPessoasPorNome(String nome);
	
}
