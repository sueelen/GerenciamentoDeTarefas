package com.example.gerenciamentodetarefas.services;

import java.util.List;
import com.example.gerenciamentodetarefas.entities.Tarefa;

public interface TarefaService {
	Tarefa salvar(Tarefa tarefa);
	Tarefa finalizar(Long id);
	Tarefa alocarPessoa(Long idTarefa, Long idPessoa);
	List<Tarefa> consultarMaisAntigasSemPessoaAlocada(Integer qtdeRegistros);
}