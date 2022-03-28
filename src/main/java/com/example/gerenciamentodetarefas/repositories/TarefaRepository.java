package com.example.gerenciamentodetarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciamentodetarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
}