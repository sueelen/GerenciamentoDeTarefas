package com.example.gerenciamentodetarefas.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciamentodetarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	List<Tarefa> findByPessoasIsEmptyOrderByPrazo(Pageable pageable);
	
}