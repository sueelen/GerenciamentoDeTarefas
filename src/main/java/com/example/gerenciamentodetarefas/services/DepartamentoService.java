package com.example.gerenciamentodetarefas.services;

import java.util.List;

import com.example.gerenciamentodetarefas.entities.Departamento;

public interface DepartamentoService {
	
	public Departamento salvar(Departamento departamento);
	
    public List<Departamento> listarDepartamentos();
    
    public Departamento consultarDepartamento(Integer idDepartamento);
	
}