package com.example.gerenciamentodetarefas.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.gerenciamentodetarefas.entities.Pessoa;
import com.example.gerenciamentodetarefas.exceptions.PessoaNotFoundException;
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

	@Override
	public Pessoa consultarPessoa(Long id) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
		if(pessoaOptional.isPresent()) {
			return pessoaOptional.get();
		}
		throw new PessoaNotFoundException();
	}
	
	@Override
	public List<Pessoa> consultarPessoasPorNome(String nome) {
		List<Pessoa> pessoas = pessoaRepository.findByNomeContainingIgnoreCase(nome);
		if(!pessoas.isEmpty()) {
			return pessoas;
		}
		throw new PessoaNotFoundException();
	}

	@Override
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}
	
}
