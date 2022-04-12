package com.example.gerenciamentodetarefas.services.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.example.gerenciamentodetarefas.entities.Pessoa;
import com.example.gerenciamentodetarefas.entities.Tarefa;
import com.example.gerenciamentodetarefas.exceptions.DepartamentoNaoCompativelException;
import com.example.gerenciamentodetarefas.exceptions.TarefaNotFoundException;
import com.example.gerenciamentodetarefas.repositories.TarefaRepository;
import com.example.gerenciamentodetarefas.services.PessoaService;
import com.example.gerenciamentodetarefas.services.TarefaService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {
	
	private final TarefaRepository tarefaRepository;
	private final PessoaService pessoaService;

	@Override
	public Tarefa salvar(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	@Override
	public Tarefa finalizar(Long id) {
		Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
		if (tarefaOptional.isPresent()) {
			tarefaOptional.get().setFinalizado(true);
			return salvar(tarefaOptional.get());
		}
		return null;
	}

	@Override
	public Tarefa alocarPessoa(Long idTarefa, Long idPessoa) {
		Optional<Tarefa> tarefaOptional = tarefaRepository.findById(idTarefa);
		if(tarefaOptional.isPresent()) {
			Pessoa pessoa = pessoaService.consultarPessoa(idPessoa);
			if(pessoa.getDepartamento().getId()==tarefaOptional.get().getDepartamento().getId()) {
				if(tarefaOptional.get().getPessoas() == null) {
					tarefaOptional.get().setPessoas(new ArrayList<Pessoa>());
				}
				tarefaOptional.get().getPessoas().add(pessoa);
				return salvar(tarefaOptional.get());
			}
			else {
				throw new DepartamentoNaoCompativelException();
			}
		}
		else {
			throw new TarefaNotFoundException();
		}
	}

	@Override
	public List<Tarefa> consultarMaisAntigasSemPessoaAlocada(Integer qtdeRegistros) {
		return tarefaRepository.findByPessoasIsEmptyOrderByPrazo(Pageable.ofSize(qtdeRegistros));
	}
}