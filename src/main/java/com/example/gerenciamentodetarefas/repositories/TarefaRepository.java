package com.example.gerenciamentodetarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gerenciamentodetarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	@Query("SELECT t FROM Tarefa t WHERE t.pessoas IS EMPTY ORDER BY p.prazo limit ?0")
	List<Tarefa> findMaisAntigasSemPessoasAlocadas(Integer qtdeRegistros);
	
}