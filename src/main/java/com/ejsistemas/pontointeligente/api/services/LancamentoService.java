package com.ejsistemas.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ejsistemas.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	/**
	 * Retorna uma lista paginada de laçamentos de um determinado funcionáro.
	 * 
	 * @Param funcionarioId
	 * @Param pageRequest
	 * @return 	Page<Lancamento>
	 * 
	 */
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna uma lançamento por Id.
	 * 
	 * @Param id
	 * @return Optional<Lancamento>
	 * 
	 */
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * Persiste um Lançamento na base de dados.
	 * 
	 * @Param lancamento
	 * @return Lancamento
	 * 
	 */
	Lancamento persistir(Lancamento lancameto);
	
	/**
	 * Remove um lançamento da base de dados.
	 * 
	 * @Param id
	 * 
	 */
	void remover(Long id);

}
