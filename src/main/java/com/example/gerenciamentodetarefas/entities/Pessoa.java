package com.example.gerenciamentodetarefas.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@NotBlank(message = "O campo nome não pode ser nulo!")
    @Column(name="nome", length=150, nullable=false)
	private String nome;
    
	@NotNull(message = "O departamento não pode ser nulo!")
    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento departamento;
    
	@JsonIgnore
    @ManyToMany(mappedBy = "pessoas")
    private List<Tarefa> listaDeTarefas;
    
	@JsonIgnore
    public Long getToralHorasGastasTarefas() {
    	return listaDeTarefas.stream().mapToLong(tarefa -> tarefa.getFinalizado() ? tarefa.getDuracao() : 0).sum();
    }
    
	@JsonIgnore
    public Double getMediaHorasGastasTarefasPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
    	OptionalDouble mediaOptional = listaDeTarefas.stream().mapToLong(tarefa ->
    	(tarefa.getPrazo().isEqual(dataInicio) || tarefa.getPrazo().isAfter(dataInicio)) &&
    	(tarefa.getPrazo().isEqual(dataFim) || tarefa.getPrazo().isBefore(dataFim)) &&
    	tarefa.getFinalizado() ? tarefa.getDuracao() : 0).average();
    	return mediaOptional.isPresent() ? mediaOptional.getAsDouble() : null;
    }
    
}
