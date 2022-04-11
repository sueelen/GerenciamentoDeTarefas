package com.example.gerenciamentodetarefas.controller.converter;

import java.time.LocalDate;
import java.util.List;
import com.example.gerenciamentodetarefas.controller.data.response.PessoaGastosResponse;
import com.example.gerenciamentodetarefas.controller.data.response.PessoaResponse;
import com.example.gerenciamentodetarefas.entities.Pessoa;

public interface PessoaResponseConverter {
	
	PessoaResponse convertToPessoaResponse(Pessoa pessoa);
	List<PessoaResponse> convertToPessoaResponseList(List<Pessoa> pessoas);
	
	PessoaGastosResponse convertToPessoaGastosResponse(Pessoa pessoa, LocalDate dataInicial, LocalDate dataFim);
	List<PessoaGastosResponse> convertToPessoaGastosResponseList(List<Pessoa> pessoas, LocalDate dataInicial, LocalDate dataFim);

}
