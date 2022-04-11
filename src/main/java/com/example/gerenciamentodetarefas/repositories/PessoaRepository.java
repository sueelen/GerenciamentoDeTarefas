package com.example.gerenciamentodetarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciamentodetarefas.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	List<Pessoa> findByNomeContainingIgnoreCase(String nome);
	
}
