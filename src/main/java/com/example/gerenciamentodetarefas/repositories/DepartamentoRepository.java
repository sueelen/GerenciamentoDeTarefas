package com.example.gerenciamentodetarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciamentodetarefas.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
}