package com.example.gerenciamentodetarefas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="pessoa")
public class Pessoa {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @Column(name="nome", length=150, nullable=false)
	private String nome;
    
    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento departamento;
    
    @OneToMany(mappedBy="pessoa") 
    private List<Tarefa> listaDeTarefas;
    
}
