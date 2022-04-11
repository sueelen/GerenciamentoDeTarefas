package com.example.gerenciamentodetarefas.controller.converter.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.gerenciamentodetarefas.controller.converter.PessoaResponseConverter;
import com.example.gerenciamentodetarefas.controller.data.response.PessoaGastosResponse;
import com.example.gerenciamentodetarefas.controller.data.response.PessoaResponse;
import com.example.gerenciamentodetarefas.entities.Pessoa;

@Component
public class PessoaResponseConverterImpl implements PessoaResponseConverter {

	@Override
	public PessoaResponse convertToPessoaResponse(Pessoa pessoa) {
		if(pessoa == null) {
			return null;
		}
		return PessoaResponse.builder()
			.nome(pessoa.getNome())
			.departamento(pessoa.getDepartamento().getDescricao())
			.totalHorasGastasTarefas(pessoa.getToralHorasGastasTarefas())
			.build();
	}

	@Override
	public List<PessoaResponse> convertToPessoaResponseList(List<Pessoa> pessoas) {
		if(pessoas == null) {
			return new ArrayList<PessoaResponse>();
		}
		return pessoas.stream().map((pessoa) -> convertToPessoaResponse(pessoa)).collect(Collectors.toList());
	}

	@Override
	public PessoaGastosResponse convertToPessoaGastosResponse(Pessoa pessoa, LocalDate dataInicial, LocalDate dataFim) {
		if(pessoa == null) {
			return null;
		}
		return PessoaGastosResponse.builder()
			.nome(pessoa.getNome())
			.mediaHorasGastasTarefas(pessoa.getMediaHorasGastasTarefasPorPeriodo(dataInicial, dataFim))
			.build();
	}

	@Override
	public List<PessoaGastosResponse> convertToPessoaGastosResponseList(List<Pessoa> pessoas, LocalDate dataInicial, LocalDate dataFim) {
		if(pessoas == null) {
			return new ArrayList<PessoaGastosResponse>();
		}
		return pessoas.stream().map((pessoa) -> convertToPessoaGastosResponse(pessoa, dataInicial, dataFim)).collect(Collectors.toList());
	}

}
