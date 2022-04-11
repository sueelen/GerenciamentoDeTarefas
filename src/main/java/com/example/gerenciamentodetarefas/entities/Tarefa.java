package com.example.gerenciamentodetarefas.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Entity(name="tarefa")
public class Tarefa {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "O campo titulo não pode ser nulo!")
    @Column(name="titulo", length=150, nullable=false)
	private String titulo;
    
	@NotBlank(message = "O campo descrição não pode ser nulo!")
    @Column(name="descricao", length=1000, nullable=false)
	private String descricao;
    
	@NotNull(message = "O campo prazo não pode ser nulo!")
    @Column(name = "prazo", columnDefinition = "DATE", nullable=false)
    private LocalDate prazo;
    
    @NotNull(message = "O departamento não pode ser nulo!")
    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento departamento;
    
    @NotNull(message = "O campo duracao não pode ser nulo!")
    @Column(name="duracao", nullable=false)
    private Integer duracao;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
      name = "pessoasTarefas", 
      joinColumns = @JoinColumn(name = "idTarefa"), 
      inverseJoinColumns = @JoinColumn(name = "idPessoa"))
    private List<Pessoa> pessoas;
    
    @NotNull(message = "O campo finalizado precisa estar preenchido.")
    @Column(name="finalizado", nullable=false)
    private Boolean finalizado;
    
}
