package com.example.gerenciamentodetarefas.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
    @Column(name="titulo", length=150, nullable=false)
	private String titulo;
    
    @Column(name="descricao", length=1000, nullable=false)
	private String descricao;
    
    @Temporal(TemporalType.DATE)
    private LocalDate prazo;
    
    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento departamento;
    
    @Column(name="duracao", nullable=false)
    private Integer duracao;
    
    @ManyToOne
    @JoinColumn(name="idPessoa")
    private Pessoa pessoa;
    
    @Column(name="finalizado", nullable=false)
    private Boolean finalizado;
    
}
