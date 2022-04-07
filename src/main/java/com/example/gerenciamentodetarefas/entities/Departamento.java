package com.example.gerenciamentodetarefas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="departamento")
public class Departamento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "O campo descrição não pode ser nulo!")
    @Column(name="descricao", length=150, nullable=false)
	private String descricao;
    
    @OneToMany(mappedBy="departamento", fetch = FetchType.LAZY) 
    private List<Tarefa> tarefas;
    
    @OneToMany(mappedBy="departamento", fetch = FetchType.LAZY) 
    private List<Pessoa> pessoas;
	
}
